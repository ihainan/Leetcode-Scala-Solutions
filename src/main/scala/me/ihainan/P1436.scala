package me.ihainan

object P1436 {
  def destCity(paths: List[List[String]]): String = {
    val map = collection.mutable.Map.empty[String, List[String]].withDefaultValue(Nil)
    paths.foreach { case List(s, e) => map(s) = map(s) :+ e }
    paths.foreach { case List(s, e) => if (map(e).size == 0) return e }
    ""
  }
}