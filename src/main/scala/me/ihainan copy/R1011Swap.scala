package me.ihainan

object R1011Swap {
  def wiggleSort(nums: Array[Int]): Unit = {
    (1 until nums.length).foreach { i =>
      if ((i % 2 == 0 && nums(i) > nums(i - 1)) || (i % 2 == 1 && nums(i) < nums(i - 1))) {
        val tmp = nums(i - 1)
        nums(i - 1) = nums(i)
        nums(i) = tmp
      }
    }
  }
}