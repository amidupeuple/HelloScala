package chapter11

class ASCIIArt(val artObject: String) {
  def this () = {
    this("")
  }

  def + (other: ASCIIArt): ASCIIArt = {
    var thisArr: Array[String] = artObject.split("\n")
    var otherArr: Array[String] = other.artObject.split("\n")
    var maxRowLength = 0
    for (el <- thisArr) {
      if (el.length > maxRowLength) {
        maxRowLength = el.length
      }
    }
    if (thisArr.length < otherArr.length) {
      val diff = otherArr.length - thisArr.length
      val thisArrBuff = thisArr.toBuffer
      for (i <- 0 to diff) {
        thisArrBuff ++ (" " * maxRowLength)
      }
      thisArr = thisArrBuff.toArray
    } else {
      val diff = thisArr.length - otherArr.length
      val otherArrBuff = otherArr.toBuffer
      for (i <- 0 to diff) {
        otherArrBuff ++ ("")
      }
      otherArr = otherArrBuff.toArray
    }
    var newArtObj: String = ""
    for (i <- 0 to thisArr.length-1) {
      newArtObj += thisArr(i) + " " + otherArr(i) + "\n"
    }
    new ASCIIArt(newArtObj)
  }

  def ^ (other: ASCIIArt): ASCIIArt = {
    new ASCIIArt(artObject + "\n" + other.artObject)
  }

  def * (n: Integer): ASCIIArt = {
    var res: ASCIIArt = new ASCIIArt()
    for (i <- 0 to n-2) {
      res = res + this
    }
    res + this
  }

  def showArt() = {
    println(artObject)
  }
}

object ASCIIArt extends App {
  /*val ao1 = new ASCIIArt(" /\\_/\\\n( ' ' )\n(  -  )\n | | |\n(__|__)")
  val ao2 = new ASCIIArt("    -----  \n / Hello \\ \n<  Scala |\n  \\ Coder / \n   -----  ")
  val ao3 = new ASCIIArt("***\n   \n***\n   \n***")
  ((ao3 + ao3 + ao3) ^ (ao3 + ao1 + ao2 + ao3) ^ (ao3 + ao3 + ao3)).showArt*/

  val ao3 = new ASCIIArt("***\n   \n***\n   \n***")
  (ao3 * 3).showArt
}
