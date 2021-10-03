package me.ihainan

object P42 {
  def trap(height: Array[Int]): Int = {
    val len = height.length
    val leftMost = new Array[Int](len)
    val rightMost = new Array[Int](len)
    height.indices.foreach { i =>
      val j = len - i - 1
      if (i == 0) {
        leftMost(i) = height(i)
        rightMost(j) = height(j)
      } else {
        leftMost(i) = leftMost(i - 1).max(height(i))
        rightMost(j) = rightMost(j + 1).max(height(j))
      }
    }

    var ans = 0
    (1 until len - 1).foreach { i =>
      if (leftMost(i - 1) > height(i) && rightMost(i + 1) > height(i)) {
        ans += leftMost(i - 1).min(rightMost(i + 1)) - height(i)
      }
    }
    ans
  }
}
