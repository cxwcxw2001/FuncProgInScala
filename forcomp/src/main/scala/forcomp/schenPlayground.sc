import forcomp.Anagrams.Occurrences
//import forcomp.Anagrams.{Occurrences, combinations}
//
//def combinations(occurrences: Occurrences): List[Occurrences] = {
//  // borrowed from https://github.com/bpasieka/coursera-functional-programming-principles-in-scala/blob/master/week_6/1_forcomp/src/main/scala/forcomp/Anagrams.scala
//  List() :: (for (
//    (char, count) <- occurrences;
//    subsetCounter <- 1 to count;
//    otherSubsets <- combinations(occurrences.filter(_._1 > char))
//  ) yield List((char, subsetCounter)) ++ otherSubsets
//    )
//}
//
//val occurrences=List(('a', 2), ('b', 2), ('c', 1))
//combinations(occurrences).foreach(println)


def subtract(x: Occurrences, y: Occurrences): Occurrences = {
  val yMap = y.toMap.withDefaultValue(0)
  (for ((charX, countX) <- x) yield (charX, countX - yMap.apply(charX)))
    .filter(_._2 > 0)
}

val x = List(('a', 1), ('d', 1), ('l', 1), ('r', 3))
val y = List(('r', 1), ('d', 2))
subtract(x, y)