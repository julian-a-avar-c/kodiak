package kodiak.cli

import scala.scalanative.unsafe.{Zone, CQuote}
import scala.scalanative.libc.stdio.{printf}
import kodiak.cli.util.{unsafeToCString}

import fastparse.Parsed.{Success, Failure}

def ast(inputFile: os.Path) = Zone {
  printf(
    c"Welcome to Kodiak %s AST Parser!\n",
    kodiak.version.unsafeToCString,
  )
  printf(c"Parsing %s.\n", inputFile.toString.unsafeToCString)
  printf(c"\n")

  val content = os.read(inputFile)

  // val parsedContent = parse(content, document) match
  //   case Success(value, index) =>
  //     "" // value
  //   case f @ Failure(failureString, index, extra) =>
  //     val trace = f.trace(enableLogging = true)
  //     printf(c"%s\n", trace.longAggregateMsg.unsafeToCString)
  //     "ERROR"

  // printf(c"%s\n", parsedContent.unsafeToCString)
}
