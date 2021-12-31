package me.ihainan

object P215 {
  def findKthLargest(nums: Array[Int], k: Int): Int = {
    def swap(i: Int, j: Int): Unit = {
      val tmp = nums(i)
      nums(i) = nums(j)
      nums(j) = tmp
    }
    
    val target = nums.length - k

    def quickFind(l: Int, r: Int): Unit = {
      val tmp = nums(l)
      var (i, j) = (l, r)
      while (i < j) {
        while (i < j && nums(j) > tmp) j -= 1
        while (i < j && nums(i) <= tmp) i += 1
        swap(i, j)
      }
      swap(l, i)
      if (i > target) quickFind(l, i - 1)
      else if (i < target) quickFind(i + 1, r)
    }

    quickFind(0, nums.length - 1)
    nums(target)
  }
}