package chapter17
import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.io.StdIn
import scala.concurrent.duration.Duration
import scala.concurrent.duration._

object Runner6 {
  def repeat[T](action: => T, until: T => Boolean): Future[String] ={
    /*val f1 = Future {action}
    def runf2(p: T): Future[Boolean] = {
      Future {
        until(p)
      }
    }
    f1.flatMap(r => runf2(r)).onComplete{ x =>
      x match {
        case scala.util.Success(res) => println(s"Result: ${res}")
        case _ => println("Error")
      }
    }*/

    Future{"F I N"}
  }

  def main(args: Array[String]): Unit = {
    val checkPass = (p: String) => {
      Thread.sleep(3000)
      p.equals("admin")
    }

    val f = repeat(StdIn.readLine("enter password: "), checkPass)
    f.onComplete {
      case scala.util.Success(res) => println(res)
      case _ => println("Other...")
    }
  }

}
