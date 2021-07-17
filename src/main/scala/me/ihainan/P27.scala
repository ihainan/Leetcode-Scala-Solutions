package me.ihainan

object P27 {
  def removeElement(nums: Array[Int], v: Int): Int = {
    var (i, j) = (0, nums.length - 1)
    while (i <= j) {
      while (i <= j && nums(i) != v) i += 1
      if (i <= j) {
        val tmp = nums(i)
        nums(i) = nums(j)
        nums(j) = tmp
      }
      j -= 1
    }
    i
  }
}
