package com.pesiykot.util

package object random {
  private var prev = 0
  private val a = 1664525
  private val b = 1013904223
  private val n = 32
  def setSeed(seed: Int): Unit = {
    prev = seed
  }
  def nextInt(): Int = {
    prev = ((prev * a + b) % n).toInt
    prev
  }
  def nextDouble(): Double = {
    prev = (prev * a + b) % n
    prev
  }
}

class Account {
  private var balance = 0
  def showBalance = balance
  def raise(amount: Int) = {
    balance += amount
  }
}

package random {
  object GeneratorApp extends App {
    var acc = new Account
    println(acc.showBalance)
    acc.raise(100)
    println(acc.showBalance)
    println(acc.getClass)
  }
}
