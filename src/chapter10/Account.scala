package chapter10

trait Logger {
  def log(message: String)
}

trait ConsoleLogger extends Logger {
  def log(message: String): Unit = {
    println(message)
  }
}

abstract class Account extends Logger {
  def login() = {
    log("user logged in")
  }
}

object Runner extends App {
  val acc = new Account with ConsoleLogger
  acc.login
}
