package chapter10

/*trait Logger {
  def log(msg: String)
}

trait ConsoleLogger extends Logger {
  def log(msg: String): Unit = {
    println(msg)
  }
}

trait CryptoLogger extends Logger {
  val shift: Int = 3

  def encrypt(msg: String): String = {
    var result = ""
    for (c <- msg) {
      result += (c.toInt + shift).toChar
    }
    result
  }

  abstract override def log(msg: String) = {
    val encrypted = encrypt(msg)
    super.log(encrypted)
  }
}

class SignalGenerator extends ConsoleLogger with CryptoLogger {
  def generate(): Unit = {
    log("signal generated")
  }
}

object AppRunner extends App {
  val sg1 = new SignalGenerator
  sg1.generate()
  val sg2 = new {override val shift = 0} with SignalGenerator
  sg2.generate()
}*/
