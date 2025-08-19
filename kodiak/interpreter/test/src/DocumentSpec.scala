package kodiak.interpreter

import kodiak.parser.Ast
import kodiak.interpreter.Interpreter
import kodiak.interpreter.Interpreter.{*, given}

class DocumentSpec extends InterpreterSpec:
  test("Empty document") {
    assertInterpret(
      input = Ast.Document(),
      expected = Ast.Unit,
    )
  }

  test("Document with single integer") {
    assertInterpret(
      input = Ast.Document(Ast.Integer(42)),
      expected = Ast.Integer(42),
    )
  }

  test("Document with function application") {
    assertInterpret(
      input = Ast.Document(
        Ast.FunctionApplication(
          Ast.PathApplication(Ast.Integer(42), Ast.Id("+")),
          Ast.Tuple(Ast.Integer(1)),
        ),
      ),
      expected = Ast.Integer(43),
    )
  }

end DocumentSpec
