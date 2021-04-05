package me.ihainan

object P781 {
  def numRabbits(answers: Array[Int]): Int = {
    val map = collection.mutable.Map.empty[Int, Int].withDefaultValue(0)
    answers.foreach { num => map(num) = map(num) + 1}
    map.map { case (k, v) => math.ceil((v * 1.0 / (k + 1))).toInt * (k + 1) }.sum
  }
}