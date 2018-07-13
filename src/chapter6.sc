object Point {
  def apply(x: Int, y: Int) = new Point(x, y)
}

class Point private(var x: Int, var y: Int) {

}

var p1 = Point(2, 3)
p1.x