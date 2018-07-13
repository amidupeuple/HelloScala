import scala.beans.BeanProperty

class Student(@BeanProperty name: String, @BeanProperty var id: Long) {

}

var s = new Student("Mike", 1L)
s.id

class Person(var age: Int) {
  age = if (age < 0) 0 else age
}

var p = new Person(-1)
println(p.age)
