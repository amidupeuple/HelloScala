package chapter17

import scala.collection.mutable.ArrayBuffer
import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

object Runner7 extends App {
  val numberOfProc = 3
  val input: Integer = 1623
  val step = input / 3
  val intervals = ArrayBuffer[(Int, Int)]()
  for (i <- 1 to numberOfProc) {
    val from = (i-1)*step + 1
    val to: Int = if (i == numberOfProc) input else i*step
    println(s"from:${from} to:${to}")
    intervals.+=((from, to))
  }
  var tasks = List[Future[Int]]()
  for ((f, t) <- intervals) {
    val task: Future[Int] = Future {
      var c = 0
      for (i <- f to t ) {
        val tmp = BigInt(i)
        if (tmp.isProbablePrime(100)) c += 1
      }
      println(s"Thread ${Thread.currentThread().getName} finishes")
      c
    }
    tasks = tasks :+ task
  }
  val res = Future.reduceLeft(tasks)(_ + _)
  res.onComplete {
    case scala.util.Success(r) => println(r)
    case _ => println("Other...")
  }
  Await.ready(res, 1 minute)
}
