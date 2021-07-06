package me.ihainan

object P726 {
  def countOfAtoms(formula: String): String = {
    val s1 = collection.mutable.Stack.empty[(String, Int)]
    val s2 = collection.mutable.Stack.empty[(String, Int)]
    val map = collection.mutable.Map.empty[String, Int].withDefaultValue(0)
    var i = 0

    while (i < formula.length) {
      formula(i) match {
        case '(' =>
          s1.push(("(", 0))
          i += 1
        case c if Character.isUpperCase(c) =>
          var j = i + 1
          while (j < formula.length && Character.isLowerCase(formula(j))) j += 1
          val name = formula.substring(i, j)
          i = j
          while (j < formula.length && Character.isDigit(formula(j))) j += 1
          val count = if (i != j) formula.substring(i, j).toInt else 1
          s1.push((name, count))
          i = j
        case ')' =>
          i += 1
          var j = i
          while (j < formula.length && Character.isDigit(formula(j))) j += 1
          val count = if (i != j) formula.substring(i, j).toInt else 1
          i = j
          while (s1.top._1 != "(") {
            val item = s1.pop
            s2.push((item._1, item._2 * count))
          }
          s1.pop
          while (s2.nonEmpty) s1.push(s2.pop)
      }
    }

    while (s1.nonEmpty) {
      val item = s1.pop
      map(item._1) = map(item._1) + item._2
    }
    map.toArray.sortBy(_._1).map { item =>
      if (item._2 == 1) item._1
      else s"${item._1}${item._2}"
    }.mkString
  }
}