default:
  just --list

test-parser:
  ./mill -w kodiak.parser.jvm.test.testOnly \
    kodiak.parser.CommentSpec \
    kodiak.parser.KeywordSpec \
    kodiak.parser.expr.ExprSpec \
    kodiak.parser.expr.ApplicationSpec \
    kodiak.parser.expr.literal.NumberSpec
# \
# kodiak.parser.expr.ExprSpec \
# kodiak.parser.expr.literal.TextSpec \
# kodiak.parser.expr.literal.NumberSpec \
# kodiak.parser.expr.literal.CollectionSpec

ast:
  ./mill kodiak.cli ast ./examples/0.hello-world.kodiak

repl-with-file:
  ./mill kodiak.cli repl ./examples/0.hello-world.kodiak
