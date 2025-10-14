package kodiak.antlr

import kodiak.antlr.KodiakParser.{
  ProgramContext,
  IdContext,
  StmtsContext,
  StmtContext,
  StmtSepContext,
  DeclContext,
  ValDeclContext,
  VarDeclContext,
  SetDeclContext,
  LetDeclContext,
  AssignmentContext,
  CollectionContext,
  CollectionAssignmentContext,
  AnyExprContext,
  TypeContext,
  CtlExprContext,
  IfExprContext,
  MatchExprContext,
  MatchBranchContext,
  MatchBranchPatternWithContext,
  MatchBranchPatternElseContext,
  ForExprContext,
  GeneratorStmtsContext,
  WhileExprContext,
  FnExprContext,
  SimpleExprContext,
  ArgsContext,
  GroupContext,
  AnyCollectionContext,
  NamedCollectionContext,
  SomeNamedCollectionContext,
  TupleArgsContext,
  ArrayArgsContext,
  SetArgsContext,
  TupleGroupContext,
  ArrayGroupContext,
  SetGroupContext,
  TupleExprContext,
  ArrayExprContext,
  SetExprContext,
  NamedTupleExprContext,
  CollectionItemsContext,
  NamedCollectionItemsContext,
  TextBlockContext,
  TextWordContext,
  DecimalContext,
  IntegerContext,
  NumberBlockContext,
  NumberWordContext,
  PlainIdContext,
  IdWordContext,
  IdBlockContext,
  RawBlockContext,
  StmtBlockContext,
  IdHeadContext,
  WordContext,
  SlContext,
  NlContext,
  WsContext,
  SswsContext,
  GeneratorStmtContext,
  GeneratorConditionalContext,
  NamedArrayExprContext,
  SomeNamedArrayExprContext,
  SomeNamedCollectionItemsContext,
  NamedSetExprContext,
  SomeNamedSetExprContext,
  SomeNamedTupleExprContext,
}

type KodiakParserContext =
  ProgramContext | StmtsContext | StmtContext | StmtSepContext
  //
  | DeclContext | ValDeclContext | VarDeclContext | SetDeclContext |
    LetDeclContext | AssignmentContext | CollectionAssignmentContext
    //
    | AnyExprContext | TypeContext
    //
    | CtlExprContext | IfExprContext | MatchExprContext | MatchBranchContext |
    MatchBranchPatternWithContext | MatchBranchPatternElseContext |
    ForExprContext | GeneratorStmtsContext | GeneratorStmtContext |
    GeneratorConditionalContext | WhileExprContext
    //
    | FnExprContext
    //
    | SimpleExprContext
    //
    | ArgsContext | GroupContext | AnyCollectionContext | CollectionContext |
    NamedCollectionContext | SomeNamedCollectionContext
    //
    | TupleArgsContext | ArrayArgsContext | SetArgsContext
    //
    | TupleGroupContext | ArrayGroupContext | SetGroupContext
    //
    | TupleExprContext | ArrayExprContext | SetExprContext |
    NamedTupleExprContext | NamedArrayExprContext | NamedSetExprContext |
    SomeNamedTupleExprContext | SomeNamedArrayExprContext |
    SomeNamedSetExprContext
    //
    | CollectionItemsContext | NamedCollectionItemsContext |
    SomeNamedCollectionItemsContext
    //
    | TextBlockContext | TextWordContext
    //
    | DecimalContext | IntegerContext | NumberBlockContext | NumberWordContext
    //
    | IdContext | PlainIdContext | IdWordContext | IdBlockContext
    //
    | RawBlockContext | StmtBlockContext | IdHeadContext | WordContext |
    SlContext | NlContext | WsContext | SswsContext
