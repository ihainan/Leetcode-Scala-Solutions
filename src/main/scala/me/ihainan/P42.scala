package me.ihainan

object P42 {
  def trap(height: Array[Int]): Int = {
    var max = 0
    val left = height.map { h => max = max.max(h); max }
    max = 0
    val right = height.reverse.map { h => max = max.max(h); max }.reverse
    var ans = 0
    height.indices.foreach { i =>
      if (i != 0 && i != height.length - 1) {
        if (left(i - 1).min(right(i + 1)) > height(i)) {
          ans += left(i - 1).min(right(i + 1)) - height(i)
        }
      }
    }
    ans
  }
}