package me.ihainan

object P540 {
  def singleNonDuplicate(nums: Array[Int]): Int = {
    def find(l: Int, r: Int): Int = {
      if (l >= r) nums(l)
      else {
        val m = (l + r) >>> 1
        if (nums(m) == nums(m - 1)) {
          if ((m - 1) % 2 == 0) find(m + 1, r)
          else find(l, m - 2)
        } else if (nums(m) == nums(m + 1)) {
          if (m % 2 == 0) find(m + 2, r)
          else find(l, m - 1)
        } else nums(m)
      }
    }

    find(0, nums.length - 1)
  }
}
