package me.ihainan

object P1176 {
  def dietPlanPerformance(calories: Array[Int], k: Int, lower: Int, upper: Int): Int = {
    var score = 0
    (k - 1 until calories.length).map { i =>
      if (i < k) score = (0 until k).map(i => calories(i)).sum
      else score += calories(i) - calories(i - k)
      if (score > upper) 1
      else if (score < lower) -1
      else 0
    }.sum
  }
}