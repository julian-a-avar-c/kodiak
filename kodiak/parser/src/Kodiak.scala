package kodiak.parser

import language.implicitConversions
import fastparse.*

import kodiak.parser.example.syntax.*
import kodiak.parser.example.*

import kodiak.parser.bak.KodiakWhitespace.whitespace

/** Parser for Kodiak syntax.
  */
object Kodiak extends Core with Types with Exprs:

  def TmplBody[$: P]: P[Unit] =
    def Prelude  = P((Annot ~ OneNLMax).rep ~ Mod./.rep)
    def TmplStat = P(Import | Prelude ~ BlockDef | StatCtx.Expr)

    P(
      "{" ~/ BlockLambda.? ~ Semis.? ~ TmplStat.repX(sep =
        NoCut(Semis),
      ) ~ Semis.? ~ `}`,
    )
  end TmplBody

  def ValVarDef[$: P] = P(
    BindPattern.rep(1, ","./) ~ (`:` ~/ Type).? ~ (`=` ~/ FreeCtx.Expr).?,
  )

  def FunDef[$: P] =
    def Body = P(
      WL ~ `=` ~/ `macro`.? ~ StatCtx.Expr | OneNLMax ~ "{" ~ Block ~ "}",
    )
    P(FunSig ~ (`:` ~/ Type).? ~~ Body.?)
  end FunDef

  def BlockDef[$: P]: P[Unit] = P(Dcl | TraitDef | ClsDef | ObjDef)

  def ClsDef[$: P] =
    def ClsAnnot  = P(`@` ~ SimpleType ~ ArgList.?)
    def Prelude   = P(NotNewline ~ (ClsAnnot.rep(1) ~ AccessMod.? | AccessMod))
    def ClsArgMod = P(Mod.rep ~ (`val` | `var`))
    def ClsArg    = P(
      Annot.rep ~ ClsArgMod.? ~ Id ~ `:` ~ Type ~ (`=` ~ ExprCtx.Expr).?,
    )

    def ClsArgs = P(OneNLMax ~ "(" ~/ `implicit`.? ~ ClsArg.repTC() ~ ")")
    P(
      `case`.? ~ `class` ~/ Id ~ TypeArgList.? ~~ Prelude.? ~~ ClsArgs.repX ~ DefTmpl.?,
    )
  end ClsDef

  def Constrs[$: P]      = P((WL ~ Constr).rep(1, `with`./))
  def EarlyDefTmpl[$: P] = P(TmplBody ~ (`with` ~/ Constr).rep ~ TmplBody.?)
  def NamedTmpl[$: P]    = P(Constrs ~ TmplBody.?)

  def DefTmpl[$: P]  = P((`extends` | `<:`) ~ AnonTmpl | TmplBody)
  def AnonTmpl[$: P] = P(EarlyDefTmpl | NamedTmpl | TmplBody)

  def TraitDef[$: P] = P(`trait` ~/ Id ~ TypeArgList.? ~ DefTmpl.?)

  def ObjDef[$: P]: P[Unit] = P(`case`.? ~ `object` ~/ Id ~ DefTmpl.?)

  def Constr[$: P] = P(AnnotType ~~ (NotNewline ~ ParenArgList).repX)

  def PkgObj[$: P]              = P(ObjDef)
  def PkgBlock[$: P]            = P(QualId ~/ `{` ~ TopStatSeq.? ~ `}`)
  def Pkg[$: P]                 = P(`package` ~/ (PkgBlock | PkgObj))
  def TopStatSeq[$: P]: P[Unit] =
    def Tmpl = P(
      (Annot ~~ OneNLMax).rep ~ Mod.rep ~ (TraitDef | ClsDef | ObjDef),
    )
    def TopStat = P(Pkg | Import | Tmpl)
    P(TopStat.repX(1, Semis))
  end TopStatSeq
  def TopPkgSeq[$: P] = P(((`package` ~ QualId) ~~ !(WS ~ "{")).repX(1, Semis))
  def CompilationUnit[$: P]: P[Unit] =
    def Body = P(TopPkgSeq ~~ (Semis ~ TopStatSeq).? | TopStatSeq)
    P(Semis.? ~ Body.? ~~ Semis.? ~ WL0 ~ End)
end Kodiak
