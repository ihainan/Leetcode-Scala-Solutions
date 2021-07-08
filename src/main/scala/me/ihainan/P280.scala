package me.ihainan

object P280 {
  def wiggleSort(nums: Array[Int]): Unit = {
    val sorted = nums.sorted
    var (i, j, k) = (0, sorted.length - 1, 0)
    while (k < nums.length) {
      nums(k) = sorted(i)
      if (k != nums.length - 1) nums(k + 1) = sorted(j)
      i += 1
      j -= 1
      k += 2
    }
  }
}