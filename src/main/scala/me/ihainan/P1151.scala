package me.ihainan

object P1151 {
  def minSwaps(data: Array[Int]): Int = {
    val count = data.count(_ == 1)
    var sum = (0 until count).map(i => data(i)).sum
    var ans = count - sum
    (count until data.length).foreach { i =>
      sum = sum - data(i - count) + data(i)
      ans = ans.min(count - sum)
    }
    ans
  }
}