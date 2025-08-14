package kodiak.interpreter

import kodiak.parser.Ast

trait Interpreter[T <: Ast]:
  type Self <: Ast
  extension (ast: Self) def interpret: T

object Interpreter:
  def interpret(ast: Ast): Ast =
    ast match
      case ast: Ast.Document      => ast.interpret
      case ast: Ast.ValDefinition => ???
      case ast: Ast.VarDefinition => ???
      case ast: Ast.LetDefinition => ???
      case ast: Ast.SetDefinition => ???
      // case ast: Ast.Singleline          => ???
      // case ast: Ast.Newline             => ???
      // case ast: Ast.True                => ???
      // case ast: Ast.False               => ???
      // case ast: Ast.Unit                => ???
      case ast: Ast.Id                  => ???
      case ast: Ast.PlainText           => ???
      case ast: Ast.RawText             => ???
      case ast: Ast.Integer             => ???
      case ast: Ast.Decimal             => ???
      case ast: Ast.RawNumber           => ???
      case ast: Ast.Tuple               => ???
      case ast: Ast.Seq                 => ???
      case ast: Ast.Set                 => ???
      case ast: Ast.FunctionApplication => ast.interpret
      case ast: Ast.PathApplication     => ???
      case ast: Ast.If                  => ???
      case ast: Ast.While               => ???

  given documentParser: Ast.Document is Interpreter[Ast]:
    extension (ast: Self)
      def interpret: Ast.Document =
        ast.stmts
        ???
    end extension
  end documentParser

  given numberParser: Ast.FunctionApplication is Interpreter[Ast]:
    extension (ast: Self)
      def interpret: Ast.Document =
        ast.function
        ???
    end extension
  end numberParser

end Interpreter
