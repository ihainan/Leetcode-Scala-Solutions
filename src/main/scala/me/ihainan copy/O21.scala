package me.ihainan

object O21 {
  def exchange(nums: Array[Int]): Array[Int] = {
    var (i, j) = (0, 0)
    while (j < nums.length) {
      if ((nums(j) & 1) == 1) {
        val tmp = nums(i)
        nums(i) = nums(j)
        nums(j) = tmp
        i += 1
      }
      j += 1
    }
    nums
  }
}