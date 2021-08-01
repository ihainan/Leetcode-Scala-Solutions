package me.ihainan

object LCS02 {
  def halfQuestions(questions: Array[Int]): Int = {
    val times = collection.mutable.Map.empty[Int, Int].withDefaultValue(0)
    questions.foreach { q => times(q) = times(q) + 1 }
    val sorted = times.values.toArray.sorted.reverse
    var sum = 0
    sorted.indices.collectFirst { case i if {
      sum += sorted(i);
      sum >= questions.length / 2
    } => i + 1
    }.get
  }
}