package me.ihainan

object P1713 {
  @annotation.tailrec
  def find(nums: Array[Int], l: Int, r: Int, target: Int): Int = {
    if (l > r) 0
    else if (nums(r) < target) r
    else {
      val m = (l + r) >>> 1
      if (nums(m) < target) find(nums, m, r - 1, target)
      else find(nums, l, m - 1, target)
    }
  }

  def lis(nums: Array[Int]): Int = {
    if (nums.length == 0) return 0
    val dp = new Array[Int](nums.length + 1)
    var len = 1
    dp(len) = nums(0)

    (1 until nums.length).foreach { i =>
      if (nums(i) > dp(len)) {
        len += 1
        dp(len) = nums(i)
      } else {
        val j = find(dp, 1, len, nums(i))
        dp(j + 1) = nums(i)
      }
    }

    len
  }

  def minOperations(target: Array[Int], arr: Array[Int]): Int = {
    val map = target.zipWithIndex.toMap
    val nums = arr.filter(num => map.isDefinedAt(num)).map(num => map(num))
    val len = lis(nums)
    target.length - len
  }
}