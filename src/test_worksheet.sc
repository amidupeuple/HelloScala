import java.time.LocalDate

implicit class DateInterpolator(val sc: StringContext) extends AnyVal {
  def date(args: Any*): LocalDate = {
    if (args.length != 3) {
      throw new IllegalArgumentException("number of parameters should be 3")
    }
    val y: Int = args(0).toString.toInt
    val m: Int = args(1).toString.toInt
    val d: Int = args(2).toString.toInt

    LocalDate.of(y, m, d)
  }
}

val year = 2018
val month = 8
val day = 24
date"$year-$month-$day"

