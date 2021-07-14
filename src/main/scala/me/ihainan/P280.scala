package me.ihainan

object P280 {
  def wiggleSort(nums: Array[Int]): Unit = {
    val sorted = nums.sorted
    var (i, j) = (0, nums.length - 1)
    (0 until nums.length by 2).foreach { k =>
      nums(k) = sorted(i)
      if (k != nums.length - 1) nums(k + 1) = sorted(j)
      i += 1
      j -= 1
    }
  }
}