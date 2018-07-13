class Time {
  private var state = 0

  def this(h: Int, m: Int) {
    this()
    state = h * 60 + m
  }

  def before(other: Time)= state < other.state
}

val t1 = new Time(23, 50)
val t2 = new Time(23, 55)
t1.before(t1)

