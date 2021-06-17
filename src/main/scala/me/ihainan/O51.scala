package me.ihainan

object O51 {
  def reversePairs(nums: Array[Int]): Int = {
    // 3, 1, 2, 0, bits(5)
    val sorted = nums.sorted
    val map = sorted.zipWithIndex.toMap
    val bits = new Array[Int](sorted.length + 1)

    @scala.annotation.tailrec
    def updateDelta(i: Int, delta: Int): Unit = {
      if (i <= sorted.length) {
        bits(i) += delta
        updateDelta(i + (i & -i), delta)
      }
    }

    def sum(i: Int): Int = {
      if (i <= 0) 0
      else bits(i) + sum(i - (i & -i))
    }

    var ans = 0
    (nums.length - 1 to 0 by -1).foreach { i =>
      val index = map(nums(i))
      ans += sum(index + 1)
      updateDelta(index + 2, 1)
    }

    ans
  }
}