package kodiak.cli

import scala.scalanative.unsafe.{Zone, CQuote, CChar, CInt}
import scala.scalanative.libc.stdio.{printf, puts, getchar, putchar}

import kodiak.cli.util.*
import scala.util.boundary

object chars:
  val CTRL_C = 3
  val ENTER  = 10

def repl() = Zone {
  printf(
    c"Welcome to Kodiak %s REPL!\n",
    kodiak.version.unsafeToCString,
  )
  printf(c"Type in expressions for evaluation. Or try help.\n")
  printf(c"\n")

  rawMode {
    import collection.mutable.Stack
    val stack: Stack[Stack[CInt]] = Stack.empty

    var printPrompt = true

    boundary { isRunning ?=>
      while true do
        if printPrompt then
          stack += Stack.empty
          puts(c"kodiak> ")
          printPrompt = false

        val c = getchar()

        // Early exit
        if c == chars.CTRL_C then boundary.break(isRunning)

        stack.last += c
        putchar(c)

        if c == chars.ENTER then printPrompt = true
      end while
    }

    for line <- stack do
      printf(c"%s\n", line.map(_.toChar).mkString.unsafeToCString)
  }
}
