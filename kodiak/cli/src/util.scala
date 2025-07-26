package kodiak.cli.util

import scala.collection.immutable.ArraySeq

import scala.scalanative.unsafe
import scala.scalanative.unsafe.{Zone, CString, extern, Ptr, alloc}
import scala.scalanative.posix.{termios, unistd}
import termios.{TCSANOW, termios, tcgetattr, tcsetattr}
import unistd.{STDIN_FILENO}

import glibc_termios.{cfmakeraw}

extension (string: String)
  def unsafeToCString(using zone: Zone): CString =
    unsafe.toCString(string)(using zone)

extension [T](array: Array[T])
  def unsafeWrapArray: ArraySeq[T] =
    ArraySeq.unsafeWrapArray(array)

@extern
object glibc_termios {
  def cfmakeraw(size: Ptr[termios]): Ptr[Byte] = extern
}

inline def rawMode(callback: () => Unit)(using zone: Zone) = {
  // Save original terminal settings
  val (original, raw) = (
    alloc[termios](),
    alloc[termios](),
  )

  tcgetattr(STDIN_FILENO, original);

  // Switch to raw mode
  cfmakeraw(raw);
  tcsetattr(STDIN_FILENO, TCSANOW, raw);

  // Call the callback function
  callback()

  // Restore original settings
  tcsetattr(STDIN_FILENO, TCSANOW, original);
}
