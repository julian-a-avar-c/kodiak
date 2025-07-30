package kodiak.cli

import mainargs.{main, arg, ParserForMethods, Flag}

import kodiak.cli.util.unsafeWrapArray
import kodiak.cli.util.rawMode
import scala.scalanative.unsafe.Zone

object Main:
  @main()
  def sandbox() = Zone { rawMode { kodiak.cli.util.glibc_termios.sandbox() } }

  @main()
  def repl(
      @arg()
      ast: Flag,
      @arg()
      input: Option[String],
      @arg(short = 'i')
      interactive: Flag,
  ) =
    if interactive.value then {}
    else
      if input.isEmpty
      then kodiak.cli.repl(None, ast.value)
      else
        input
          .map: input =>
            os.FilePath(input) match
              case input: os.Path    => input
              case input: os.RelPath => os.pwd / input
              case input: os.SubPath => os.pwd / input
          .filter(os.exists)
          .map(inputPath => kodiak.cli.repl(Some(inputPath), ast.value))
      end if
    end if
  end repl

  @main()
  def ast(
      @arg()
      input: Option[String],
      @arg(short = 'i')
      interactive: Option[Boolean],
  ) =
    if interactive.contains(true) then {}
    else
      input
        .map { input =>
          os.FilePath(input) match
            case input: os.Path    => input
            case input: os.RelPath => os.pwd / input
            case input: os.SubPath => os.pwd / input
        }
        .filter(os.exists)
        .map(kodiak.cli.ast)

  def main(args: Array[String]): Unit =
    ParserForMethods(this).runOrExit(args.unsafeWrapArray)
end Main
