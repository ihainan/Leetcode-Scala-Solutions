package me.ihainan

object P977 {
  def sortedSquares(nums: Array[Int]): Array[Int] = {
    var (i, j) = (0, nums.length - 1)
    val ans = new Array[Int](nums.length)
    (nums.length - 1 to 0 by -1).foreach { k =>
      val left = nums(i) * nums(i)
      val right = nums(j) * nums(j)
      if (left < right) {
        ans(k) = right
        j -= 1
      } else {
        ans(k) = left
        i += 1
      }
    }
    ans
  }
}