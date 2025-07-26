package kodiak.cli

import scala.scalanative.unsafe.{Zone, CQuote}
import scala.scalanative.libc.stdio.{printf, getchar}

import kodiak.cli.util.*

def repl() = Zone {
  printf(
    c"Welcome to Kodiak %s REPL!\n",
    kodiak.version.unsafeToCString,
  )
  printf(c"Type in expressions for evaluation. Or try help.\n")
  printf(c"\n")

  rawMode { () =>
    printf(c"kodiak> ")
    val c = getchar() // Reads instantly
  }
}
