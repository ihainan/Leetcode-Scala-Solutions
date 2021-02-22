package me.ihainan

object R0503BruteForce {
  def reverseBits(num: Int): Int = {
    var maxLen = findLongestOnes(num)
    (0 until 32).foreach { i =>
      val mask = 1 << i
      val v = if ((mask & num) == mask) 1 else 0
      if (v == 0) {
        val len = findLongestOnes(num | (1 << i))
        maxLen = maxLen.max(len)
      }
    }
    maxLen
  }

  def findLongestOnes(num: Int): Int = {
    var (count, prev, max) = (0, 0, 0)
    (0 until 32).foreach { i =>
      val mask = 1 << i
      val v = if ((mask & num) == mask) 1 else 0
      if (prev == 1 && v == 1) count += 1
      else if (v == 1) count = 1
      else count = 0
      prev = v
      max = max.max(count)
    }
    max
  }
}