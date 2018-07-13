package chapter11

class Money(d: Int, c: Int) {
  val dol: Int = d + c / 100
  val cent: Int = c % 100

  override def toString: String = s"$$$dol,$cent"

  def + (other: Money) = {
    new Money(dol + other.dol, cent + other.cent)
  }

  def - (other: Money) = {
    if (dol * 100 + cent < other.dol * 100 + other.cent) {
      throw new RuntimeException("right money can't be bigger than left money")
    } else {
      new Money(dol - other.dol, cent - other.cent)
    }
  }

  def == (other: Money) = {
    if (dol * 100 + cent == other.dol * 100 + other.cent) true
    else false
  }

  def < (other: Money): Boolean = {
    if (dol * 100 + cent < other.dol * 100 + other.cent) true
    else false
  }
}

object MoneyRunner extends App {
  val m1 = new Money(1, 115)
  println(m1.toString)
  val m2 = new Money(2, 50)
  println(m2 < m1)
}
