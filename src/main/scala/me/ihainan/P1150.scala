package me.ihainan

object P1150 {
  def isMajorityElement(nums: Array[Int], target: Int): Boolean = {
    val len = nums.length

    @annotation.tailrec
    def find(l: Int, r: Int, target: Int): Int = {
      if (l > r) len
      else if (nums(l) >= target) l
      else {
        val m = (l + r) >>> 1
        if (nums(m) >= target) find(l + 1, m, target)
        else find(m + 1, r, target)
      }
    }

    val i1 = find(0, len - 1, target)
    i1 != len && nums(i1) == target && find(0, len - 1, target + 1) - i1 > len / 2
  }
}