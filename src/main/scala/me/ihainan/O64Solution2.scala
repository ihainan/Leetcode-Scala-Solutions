package me.ihainan

object O64Solution2 {
  def sumNums(n: Int): Int = {
    def mul(a: Int, b: Int): Int = {
      var sum = 0
      var current = a
      (0 until 32).foreach { i =>
        val mask = 1 << i
        ((mask & b) != 0) && {
          sum += current
          sum >= 0
        }
        current <<= 1
      }
      sum
    }

    mul(n, n + 1) >> 1
  }
}