package kodiak.parser

import scala.annotation.tailrec

import fastparse.*

import kodiak.parser.ast.Ast

object KodiakWhitespace:
  import fastparse.internal.{Msgs, Util}

  inline def exitAndReport(ctx: ParsingRun[?])(index: Int) =
    if ctx.verboseFailures then ctx.reportTerminalMsg(index, Msgs.empty)
    ctx.freshSuccessUnit(index)

  type State = Int
  object State:
    val ToplevelWhitespace: Int               = 100
    val ToplevelCommentMaybeStart: Int        = 101
    val ToplevelCommentStart: Int             = 102
    val ToplevelSinglelineComment: Int        = 103
    val ToplevelMultilineComment: Int         = 104
    val ToplevelMultilineCommentMaybeEnd: Int = 105

    val NestedMultilineCommentMaybeStart: Int = 200
  end State

  given none: Whitespace = ctx => ctx.freshSuccessUnit()

  given multiline0: Whitespace = ctx =>
    val input = ctx.input
    @tailrec def loop(
        index: Int,
        states: Seq[State],
        nesting: Int,
    ): ParsingRun[Unit] =
      if !input.isReachable(index)
      then unreachable(ctx)(index, states.last, nesting)
      else
        val currentChar = input(index)

        states.last match
          case State.ToplevelWhitespace =>
            (currentChar) match
              case ' ' | '\t' | '\r' | '\n' =>
                loop(index + 1, states, nesting = 0)
              case '(' | '[' | '{' =>
                loop(
                  index + 1,
                  Seq(State.ToplevelCommentMaybeStart),
                  nesting,
                )
              case _ => exitAndReport(ctx)(index)
          case State.ToplevelCommentMaybeStart =>
            (currentChar) match
              case '?' =>
                loop(
                  index + 1,
                  Seq(State.ToplevelCommentStart),
                  nesting,
                )
              case _ => exitAndReport(ctx)(index - 1)
          case State.ToplevelCommentStart =>
            (currentChar) match
              case ')' | ']' | '}' =>
                loop(
                  index + 1,
                  Seq(State.ToplevelSinglelineComment),
                  nesting,
                )
              case _ =>
                loop(
                  index,
                  Seq(State.ToplevelMultilineComment),
                  nesting,
                )
          case State.ToplevelSinglelineComment =>
            (currentChar) match
              case '\n' =>
                loop(
                  index + 1,
                  Seq(State.ToplevelWhitespace),
                  nesting - 1,
                )
              case _ =>
                loop(
                  index + 1,
                  states,
                  nesting,
                )
          case State.ToplevelMultilineComment =>
            (currentChar) match
              case '?' =>
                loop(
                  index + 1,
                  Seq(State.ToplevelMultilineCommentMaybeEnd),
                  nesting,
                )
              case '(' | '[' | '{' =>
                loop(
                  index + 1,
                  Seq(State.NestedMultilineCommentMaybeStart),
                  nesting,
                )
              case _ =>
                loop(
                  index + 1,
                  states,
                  nesting,
                )
          case State.ToplevelMultilineCommentMaybeEnd =>
            (currentChar) match
              case ')' | ']' | '}' =>
                loop(
                  index + 1,
                  Seq(State.ToplevelWhitespace),
                  nesting - 1,
                )
              case _ =>
                loop(
                  index,
                  Seq(State.ToplevelMultilineComment),
                  nesting,
                )
            end match
          case State.NestedMultilineCommentMaybeStart =>
            ???
        end match
      end if
    end loop

    loop(
      index = ctx.index,
      states = Seq(State.ToplevelWhitespace),
      nesting = 0,
    )
  end multiline0

  given multiline: Whitespace = ctx ?=> Terminal.WS ~~ multiline0(ctx)

  given singleline: Whitespace = ctx =>
    val input = ctx.input
    @tailrec def loop(
        index: Int,
        states: Seq[State],
        nesting: Int,
    ): ParsingRun[Unit] =
      if !input.isReachable(index)
      then unreachable(ctx)(index, states.last, nesting)
      else
        val currentChar = input(index)

        states.last match
          case State.ToplevelWhitespace =>
            (currentChar) match
              case ' ' | '\t' =>
                loop(index + 1, states, nesting = 0)
              case '(' | '[' | '{' =>
                loop(
                  index + 1,
                  Seq(State.ToplevelCommentMaybeStart),
                  nesting,
                )
              case _ => exitAndReport(ctx)(index)
          case State.ToplevelCommentMaybeStart =>
            (currentChar) match
              case '?' =>
                loop(
                  index + 1,
                  Seq(State.ToplevelCommentStart),
                  nesting,
                )
              case _ => exitAndReport(ctx)(index - 1)
          case State.ToplevelCommentStart =>
            (currentChar) match
              case ')' | ']' | '}' =>
                loop(
                  index + 1,
                  Seq(State.ToplevelSinglelineComment),
                  nesting,
                )
              case _ =>
                loop(
                  index,
                  Seq(State.ToplevelMultilineComment),
                  nesting,
                )
          case State.ToplevelSinglelineComment =>
            (currentChar) match
              case '\n' =>
                loop(
                  index + 1,
                  Seq(State.ToplevelWhitespace),
                  nesting - 1,
                )
              case _ =>
                loop(
                  index + 1,
                  states,
                  nesting,
                )
          case State.ToplevelMultilineComment =>
            (currentChar) match
              case '?' =>
                loop(
                  index + 1,
                  Seq(State.ToplevelMultilineCommentMaybeEnd),
                  nesting,
                )
              case '(' | '[' | '{' =>
                loop(
                  index + 1,
                  Seq(State.NestedMultilineCommentMaybeStart),
                  nesting,
                )
              case _ =>
                loop(
                  index + 1,
                  states,
                  nesting,
                )
          case State.ToplevelMultilineCommentMaybeEnd =>
            (currentChar) match
              case ')' | ']' | '}' =>
                loop(
                  index + 1,
                  Seq(State.ToplevelWhitespace),
                  nesting - 1,
                )
              case _ =>
                loop(
                  index,
                  Seq(State.ToplevelMultilineComment),
                  nesting,
                )
            end match
          case State.NestedMultilineCommentMaybeStart =>
            ???
        end match
      end if
    end loop

    loop(
      index = ctx.index,
      states = Seq(State.ToplevelWhitespace),
      nesting = 0,
    )
  end singleline

  inline def exitAndReportComment(ctx: ParsingRun[?])(
      index: Int,
  ): P[Ast.MultilineComment] =
    if ctx.verboseFailures then ctx.reportTerminalMsg(index, Msgs.empty)
    ctx.freshSuccess(Ast.MultilineComment(???, ???), index)
  end exitAndReportComment

  def unreachable(
      ctx: ParsingRun[?],
  )(index: Int, state: State, nesting: Int): ParsingRun[Unit] =
    if state == State.ToplevelWhitespace || state == State.ToplevelCommentMaybeStart || state == State.ToplevelSinglelineComment
    then exitAndReport(ctx)(index)
    // if state == State.ToplevelWhitespace || state == State.ToplevelCommentMaybeStart
    // then exitAndReport(ctx)(index)
    // else if state == State.ToplevelCommentMaybeStart && nesting == 0
    // then exitAndReport(ctx)(index - 1)
    else
      ctx.cut = true
      val res = ctx.freshFailure(index)
      if ctx.verboseFailures then
        ctx.reportTerminalMsg(index, () => Util.literalize("?}"))
      res
    end if
  end unreachable
end KodiakWhitespace
