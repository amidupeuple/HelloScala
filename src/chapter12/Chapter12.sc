def values(fun: (Int) => Int, low: Int, high: Int) = {
  for (i <- low to high) yield (i, fun(i))
}

values(x => x * x, -2, 3)

def myprint(f: () => Unit) = {
  f()
}

myprint(() => print("hey!"))

val pairs = (1 to 10) zip (11 to 20)


def adjustToPair (f: ((Int, Int)) => Int) = (p: (Int, Int)) => f(p)
val f = (x: (Int, Int)) => x._1 + x._2
adjustToPair(f)((1, 2))

val adjustFunc = (f: ((Int, Int)) => Int) => (p: (Int, Int)) => f(p)
adjustFunc((x: (Int, Int)) => x._1 * x._2)(3, 4)

//8
val a1 = Array("hey", "yo", "mama")
val a2 = Array(3, 2, 4)
a1.corresponds(a2)((s: String, n: Int) => s.length == n)




