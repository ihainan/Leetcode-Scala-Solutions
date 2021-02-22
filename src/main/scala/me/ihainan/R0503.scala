package me.ihainan

object R0503 {
  def reverseBits(num: Int): Int = {
    if (num == -1) 32
    else {
      var maxLen = 0
      var (current, prev) = (0, 0)
      var num2 = num
      (0 until 32).foreach { _ =>
        if ((num2 & 1) == 1) current += 1
        else {
          prev = if ((num2 & 2) == 0) 0 else current
          current = 0
        }
        maxLen = maxLen.max(prev + current + 1)
        num2 >>= 1
      }
      maxLen
    }
  }
}