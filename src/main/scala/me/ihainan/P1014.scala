package me.ihainan

object P1014 {
  def maxScoreSightseeingPair(values: Array[Int]): Int = {
    var max = values(0)
    var ans = max
    (1 until values.length).foreach { i =>
      ans = ans.max(max + values(i) - i)
      max = max.max(values(i) + i)
    }
    ans
  }
}
