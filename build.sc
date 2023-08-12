import mill._
import mill.scalalib._

object kodiak extends ScalaModule {
  def scalaVersion = "3.3.0"

  def scalacOptions = Seq(
    "-Yexplicit-nulls"
  )

  def ivyDeps = Agg(
    ivy"com.lihaoyi::os-lib:0.9.1",
    ivy"com.lihaoyi::fastparse:3.0.2",
    // PDF generation.
    ivy"com.github.librepdf:openpdf:1.3.30",
    // Markdown parsing.
    ivy"com.vladsch.flexmark:flexmark-all:0.64.8",
  )

  object test extends ScalaTests with TestModule.Munit {
    def ivyDeps = Agg(
      ivy"org.scalameta::munit::0.7.29"
    )
  }
}
