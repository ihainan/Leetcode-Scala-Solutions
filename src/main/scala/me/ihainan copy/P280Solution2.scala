package me.ihainan

object P280Solution2 {
  def wiggleSort(nums: Array[Int]): Unit = {
    java.util.Arrays.sort(nums)
    (1 until nums.length by 2).foreach { i =>
      if (i != nums.length - 1) {
        val tmp = nums(i)
        nums(i) = nums(i + 1)
        nums(i + 1) = tmp
      }
    }
  }
}
