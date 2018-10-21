def getCharToIndexes(input: String): Unit/*Map[String, Set[Integer]]*/ = {
  input.zipWithIndex.groupBy(_._1).map(kv => (kv._1, kv._2.map(x => x._2).toSet))
    .foreach(println)
}
getCharToIndexes("Mississippi")

def foo(names: Seq[String], namesToScores: Map[String, Integer]): Seq[Integer] = {
  names.map(x => namesToScores.get(x)).filter(x => x.isDefined).map(x => x.get)
}

val r = foo(Array("Tom", "Fred", "Harry"), Map("Tom" -> 3, "Dick" -> 4, "Harry" -> 5))

"hdkjashhkuahskkhdaskjh".par.map(x=>(x, 1))
  .aggregate(Map[Char, Int]())((m, e) => m+((e._1, m.getOrElse(e._1, 0)+e._2 )),
    (m1, m2) => (m1.keySet ++ m2.keySet).map(k => (k, (m1.getOrElse(k, 0)+m2.getOrElse(k,0)))).toMap)