package kodiak.parser

import scala.annotation.tailrec

import fastparse.*

object KodiakSinglelineWhitespace:
  import fastparse.internal.{Msgs, Util}

  inline def exitAndReport(ctx: ParsingRun[?])(index: Int) =
    if ctx.verboseFailures then ctx.reportTerminalMsg(index, Msgs.empty)
    ctx.freshSuccessUnit(index)

  given whitespace: Whitespace:
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

    def apply(ctx: ParsingRun[?]) =
      val input = ctx.input
      @tailrec def rec(
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
                  rec(index + 1, states, nesting = 0)
                case '(' =>
                  rec(
                    index + 1,
                    states :+ State.ToplevelCommentMaybeStart,
                    nesting,
                  )
                case _ => exitAndReport(ctx)(index)
            case State.ToplevelCommentMaybeStart =>
              (currentChar) match
                case '?' =>
                  rec(
                    index + 1,
                    states :+ State.ToplevelCommentStart,
                    nesting,
                  )
                case _ => exitAndReport(ctx)(index - 1)
            case State.ToplevelCommentStart =>
              (currentChar) match
                case ')' =>
                  rec(
                    index + 1,
                    states :+ State.ToplevelSinglelineComment,
                    nesting,
                  )
                case _ =>
                  rec(
                    index,
                    states :+ State.ToplevelMultilineComment,
                    nesting,
                  )
            case State.ToplevelSinglelineComment =>
              (currentChar) match
                case '\n' =>
                  rec(
                    index + 1,
                    states :+ State.ToplevelWhitespace,
                    nesting - 1,
                  )
                case _ =>
                  rec(
                    index + 1,
                    states,
                    nesting,
                  )
            case State.ToplevelMultilineComment =>
              (currentChar) match
                case '?' =>
                  rec(
                    index + 1,
                    states :+ State.ToplevelMultilineCommentMaybeEnd,
                    nesting,
                  )
                case '(' =>
                  rec(
                    index + 1,
                    states :+ State.NestedMultilineCommentMaybeStart,
                    nesting,
                  )
                case _ =>
                  rec(
                    index + 1,
                    states,
                    nesting,
                  )
            case State.ToplevelMultilineCommentMaybeEnd =>
              (currentChar) match
                case ')' =>
                  rec(
                    index + 1,
                    states :+ State.ToplevelWhitespace,
                    nesting - 1,
                  )
                case _ =>
                  rec(
                    index,
                    states :+ State.ToplevelMultilineComment,
                    nesting,
                  )
              end match
            case State.NestedMultilineCommentMaybeStart =>
              ???
          end match
        end if
      end rec

      rec(
        index = ctx.index,
        states = Seq(State.ToplevelWhitespace),
        nesting = 0,
      )
    end apply

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
  end whitespace
end KodiakSinglelineWhitespace
