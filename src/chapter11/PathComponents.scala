package chapter11

import java.nio.file.{FileSystems, Path}

object PathComponents {
  /*def unapply(pathObj: Path): Option[(String, String)] = {
    if (pathObj == null) {
      None
    } else {
      Some((pathObj.getParent.toString, pathObj.getFileName.toString))
    }
  }*/

  def unapplySeq(pathObj: Path): Option[Seq[String]] = {
    if (pathObj == null) {
      None
    } else {
      Some(pathObj.toString.split("\\\\"))
    }
  }
}

object PathComponentsRunner extends App {
  val path = FileSystems.getDefault().getPath("F:\\Temp", "ALGO.txt")
  /*val PathComponents(location, filename) = path
  println(location + " | " + filename)*/
  val PathComponents(a, b, c) = path
  println("--- EXIT ---")
}