package chapter8

import scala.collection.mutable.ArrayBuffer

abstract class Item {
  def price: Double
  def description: String
}

class SimpleItem(val price: Double, val description: String) extends Item {
}

class Bundle extends Item {
  private val itemCollection = new ArrayBuffer[Item]()

  override def price: Double = {
    var total: Double = 0
    for (item <- itemCollection) {
      total += item.price
    }
    total
  }

  override def description: String = s"Bundle of items, size=${itemCollection.size}"

  def addItem(item: Item): Unit = {
    itemCollection.append(item)
  }
}

object Runner extends App {
  val si1 = new SimpleItem(12.5, "Bottle of wine")
  val si2 = new SimpleItem(4.35, "some cheese")
  println(s"si1 price: ${si1.price}")
  val b = new Bundle
  b.addItem(si1)
  b.addItem(si2)
  println(s"bundle price: ${b.price}")
}