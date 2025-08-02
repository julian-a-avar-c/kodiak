default:
  just --list

test-parser:
  ./mill -w kodiak.parser.jvm.test

ast:
  ./mill kodiak.cli ast ./examples/0.hello-world.kodiak

repl-with-file:
  ./mill kodiak.cli repl ./examples/0.hello-world.kodiak
