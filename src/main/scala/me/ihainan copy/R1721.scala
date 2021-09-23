package me.ihainan

object R1721 {
  def trap(height: Array[Int]): Int = {
    var max = 0
    val left = height.indices.map { i => ; max = max.max(height(i)); max }
    max = 0
    val right = (height.length - 1 to 0 by -1).map { i => ; max = max.max(height(i)); max }.reverse
    var ans = 0
    height.indices.foreach { i =>
      if (i > 0 && i < height.length - 1) {
        if (left(i - 1) > height(i) && right(i + 1) > height(i)) {
          ans += left(i - 1).min(right(i + 1)) - height(i)
        }
      }
    }
    ans
  }
}