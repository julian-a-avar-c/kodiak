default:
  just --list

ast:
  ./mill kodiak.cli ast ./examples/0.empty.kodiak
  ./mill kodiak.cli ast ./examples/1.comments.kodiak
