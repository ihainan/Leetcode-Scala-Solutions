package me.ihainan

object P611 {
  def isTriangle(a: Int, b: Int, c: Int): Boolean = {
    a + b > c && a + c > b && b + c > a &&
      (a - b).abs < c && (a - c).abs < b && (b - c).abs < a
  }

  def triangleNumber(nums: Array[Int]): Int = {
    val n = nums.length
    var ans = 0
    (0 until n - 2).foreach { i =>
      (i + 1 until n - 1).foreach { j =>
        (j + 1 until n).foreach { k =>
          if (isTriangle(nums(i), nums(j), nums(k))) ans += 1
        }
      }
    }
    ans
  }
}