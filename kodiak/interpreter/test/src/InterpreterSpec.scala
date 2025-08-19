package kodiak.interpreter

import kodiak.core.utils.valueCanEqualValueOfSameType

import kodiak.parser.Ast
import kodiak.interpreter.Interpreter
import org.scalactic.source.Position
import org.scalactic.Prettifier
import org.scalatest.funsuite.*

abstract class UnitSpec extends AnyFunSuite

abstract class InterpreterSpec extends UnitSpec:

  inline def assertInterpret[A <: Ast: Interpreter](
      input: A,
      expected: Ast,
  )(using
      prettifier: Prettifier,
      pos: Position,
      use: UseDefaultAssertions.type,
  ) =
    val actual =
      try
        given CanThrow[InterpreterException] = compiletime.erasedValue
        Interpreter.interpret(input)
      catch
        case e =>
          fail(s"Failed to interpret $input", e)

    assert(
      actual == expected,
      s"Expected $expected but got $actual",
    )
  end assertInterpret

end InterpreterSpec
