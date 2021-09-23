package me.ihainan

object O21Solution2 {
  def exchange(nums: Array[Int]): Array[Int] = {
    var (i, j) = (0, nums.length - 1)
    while (i < j) {
      while (i < j && (nums(j) & 1) == 0) j -= 1
      while (i < j && (nums(i) & 1) == 1) i += 1
      val tmp = nums(i)
      nums(i) = nums(j)
      nums(j) = tmp
    }
    nums
  }
}