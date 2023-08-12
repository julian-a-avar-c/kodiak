package ink.kodiak

import com.lowagie.text.Document
import scala.util.Try
import com.lowagie.text.pdf.PdfWriter
import com.lowagie.text.{Document, Paragraph}
import com.lowagie.text.pdf.{PdfName, PdfString, PdfWriter}

import java.io.FileOutputStream
import scala.util.{Try, Success, Failure}
import com.lowagie.text.Element
import com.lowagie.text.pdf.PdfDictionary
import com.lowagie.text.DocumentException
import java.io.IOException

def makePdf(filename: String, data: Vector[Element]) = {
  val document: Document = new Document()

  Try:
    PdfWriter.getInstance(document, new FileOutputStream("HelloWorld.pdf"))
    document.open()
    document.add(new Paragraph("Hello World 1"))
  match
    case Success(value) => ()
    case Failure(exception) => exception match
        case exception: DocumentException => System.err.nn
            .println(exception.getMessage())
        case exception: IOException => System.err.nn
            .println(exception.getMessage())

  document.close()
}

object main {
  def main(args: Array[String]) = {
    val inputFolder = os.pwd / "kodiak" / "resources" / "input" / "en"
    val inputFile   = inputFolder / "Kodiak_bear.md"

    val inputAST: Vector[Kast] = Vector(Kast.Paragraph("Hello World"))

    val pdfAST = inputAST.map {
      case Kast.Heading(content)   => new Paragraph(content)
      case Kast.Paragraph(content) => new Paragraph(content)
      // TODO: Ignoring for now.
      case _: Kast => new Paragraph("")
    }

    makePdf("Hello World.pdf", pdfAST)
  }
}
