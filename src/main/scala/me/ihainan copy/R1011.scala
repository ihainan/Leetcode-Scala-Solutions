package me.ihainan

object R1011 {
  def wiggleSort(nums: Array[Int]): Unit = {
    val sorted = nums.sorted
    var (i, j) = (0, sorted.length - 1)
    (sorted.indices by 2).foreach { k =>
      nums(k) = sorted(i)
      if (k != nums.length - 1) nums(k + 1) = sorted(j)
      i += 1
      j -= 1
    }
  }
}