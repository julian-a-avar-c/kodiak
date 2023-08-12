package ink.kodiak

sealed trait Kast

object Kast:
  case class Heading(content: String) extends Kast
  case class Paragraph(content: String) extends Kast

  def fromOpenPdf(openPdfAst: Any): Kast = {
    new Kast {}
  }
