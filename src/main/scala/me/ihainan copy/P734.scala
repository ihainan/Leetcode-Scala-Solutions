package me.ihainan

object P734 {

  import collection.mutable.Map

  def areSentencesSimilar(sentence1: Array[String], sentence2: Array[String], similarPairs: List[List[String]]): Boolean = {
    val map = Map.empty[String, Set[String]].withDefaultValue(Set.empty[String])

    similarPairs.foreach { case List(s1, s2) =>
      map(s1) = map(s1) + s2
      map(s2) = map(s2) + s1
    }

    sentence1.length == sentence2.length &&
      !sentence1.zip(sentence2).exists { case (s1, s2) => s1 != s2 && (!map.isDefinedAt(s1) || !map(s1)(s2)) }
  }
}