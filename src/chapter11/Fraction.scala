package chapter11

import scala.runtime.RichInt

class Fraction(n: Int, d: Int) {
  def sign(a: Int) = if (a > 0) 1 else if (a < 0) - 1 else 0
  def gcd(a: Int, b: Int): Int = if (b == 0) a.abs else gcd(b, a % b)
  private val num: Int = if (d == 0) 1 else n * sign(d) / gcd(n, d)
  private val den: Int = if (d == 0) 0 else d * sign(d) / gcd(n, d)
  override def toString = s"$num/$den"

  def *(other: Fraction) = {
    new Fraction(num * other.num, den * other.den)
  }

  def /(other: Fraction) = {
    new Fraction(num * other.den, den * other.num)
  }

  def +(other: Fraction) = {
    new Fraction(num * other.den + other.num * den, den * other.den)
  }

  def -(other: Fraction) = {
    new Fraction(num * other.den - other.num * den, den * other.den)
  }
}

object FractionRunner extends App {
  val f1 = new Fraction(-3, 4)
  val f2 = new Fraction(2, 5)
  var f3 = f1 - f2
  println(f3.toString)
  f3 = f1 * f2 + f1
  println(f3.toString)
}
