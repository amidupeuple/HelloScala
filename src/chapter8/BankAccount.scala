package chapter8

class BankAccount(initialBalance: Double) {
  private var balance = initialBalance
  def currentBalance = balance
  def withdraw(amount: Double) = {balance -= amount; balance}
  def deposit(amount: Double) = {balance += amount; balance}
}

class CheckingAccount(initialBalance: Double) extends BankAccount(initialBalance) {
  override def withdraw(amount: Double): Double = {
    super.withdraw(amount)
    super.withdraw(1)
  }

  override def deposit(amount: Double): Double =  {
    super.deposit(amount)
    super.withdraw(1)
  }
}

object AppRunner extends App {
  val acc = new BankAccount(100)
  val accX = new CheckingAccount(100)
  acc.withdraw(10)
  println(acc.currentBalance)
  accX.withdraw(10)
  println(accX.currentBalance)
}