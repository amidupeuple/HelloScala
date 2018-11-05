import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.io.StdIn
//6
def repeat[T](action: => T, until: T => Boolean): Future[T]  ={
  val f1 = Future {action}
  def runf2(p: T): Future[Boolean] = {
    Future {
      until(p)
    }
  }
  f1.flatMap(r => runf2(r)).onComplete{ x =>
    x match {
      case scala.util.Success(true) => println("Successfully logged in!")
      case _ => repeat(action, until)
    }
  }
  Future{action}
}

val action = StdIn.readLine("enter password: ")
val checkPass = (p: String) => {
    Thread.sleep(3000)
    p.equals("admin")
  }
repeat(action, checkPass)
