import scala.beans.BeanProperty

class Time {
  private[Time] var   state = 0

  def this(h: Int, m: Int) {
    this()
    state = h * 60 + m
  }

  def before(other: Time)= state < other.state
}

class Student(@BeanProperty var name: String, @BeanProperty var id: Long) {

}

class Person(fullName: String) {
  val firstName: String = fullName.split(' ')(0)
  val lastName: String = fullName.split(' ')(1)
}


object ReversePrinter extends App {
  var revArgs = args.reverse
  var res = ""
  for (i <- 0 to revArgs.length - 2)
    res += s"${revArgs(i)} "
  res += revArgs.last
  println(res)
}
