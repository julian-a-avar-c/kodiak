package kodiak.parser

import org.scalatest.flatspec.AnyFlatSpec

import org.scalatest.*
import flatspec.*
import matchers.*

abstract class UnitSpec
    extends AnyFlatSpec
    with should.Matchers
    with OptionValues
    with Inside
    with Inspectors

class KodiakWhitespaceSpec extends UnitSpec {

  "Parser" should "parse empty string" in {
    val input         = ""
    val parsedContent = parser(input) match
      case Success(value, index) =>
        value
      case f: Failure =>
        "ERROR"

    assert(parsedContent == "")
  }
}
