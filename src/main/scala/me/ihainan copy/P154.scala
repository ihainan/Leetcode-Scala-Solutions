package me.ihainan

// 备注：find 得到的并非是旋转点的索引，但是能保证对应的值是最小值
object P154 {
  def findMin(nums: Array[Int]): Int = {
    nums(find(0, nums.length - 1, nums))
  }

  @scala.annotation.tailrec
  def find(l: Int, r: Int, nums: Array[Int]): Int = {
    if (l == r) l
    else {
      val mid = (l + r) >>> 1
      if (nums(mid) > nums(r)) find(mid + 1, r, nums)
      else if (nums(mid) < nums(r)) find(l, mid, nums)
      else find(l, r - 1, nums)
    }
  }
}