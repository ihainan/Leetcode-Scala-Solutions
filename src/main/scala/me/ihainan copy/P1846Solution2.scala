package me.ihainan

object P1846Solution2 {
  def maximumElementAfterDecrementingAndRearranging(arr: Array[Int]): Int = {
    val len = arr.length
    val bucket = new Array[Int](len + 1)
    arr.foreach { num => if (num >= len) bucket(len) += 1 else bucket(num) += 1 }
    var ans = 0
    bucket.indices.foreach { i =>
      (0 until bucket(i)).foreach { _ => if (i > ans + 1) ans += 1 else ans = i }
    }
    ans
  }
}