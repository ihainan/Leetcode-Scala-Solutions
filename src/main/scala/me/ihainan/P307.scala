package me.ihainan

object P307 {

  class NumArray(_nums: Array[Int]) {
    val nums: Array[Int] = _nums
    val n: Int = nums.length
    val bit = new Array[Int](n + 1)
    System.arraycopy(nums, 0, bit, 1, n)
    (1 to n).foreach { i => val j = i + (i & -i); if (j <= n) bit(j) += bit(i) }

    def update(index: Int, `val`: Int) {
      updateDelta(index + 1, `val` - nums(index))
      nums(index) = `val`
    }

    def updateDelta(i: Int, delta: Int): Unit = {
      if (i <= n) {
        bit(i) += delta
        updateDelta(i + (i & -i), delta)
      }
    }

    def sumRange(left: Int, right: Int): Int = {
      sum(right + 1) - sum(left)
    }

    def sum(i: Int): Int = {
      if (i <= 0) 0
      else bit(i) + sum(i - (i & -i))
    }
  }

}