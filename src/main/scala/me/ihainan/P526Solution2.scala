package me.ihainan

object P526Solution2 {
  def countArrangement(n: Int): Int = {
    val dp = new Array[Int](1 << n)
    dp(0) = 1
    (1 until 1 << n).foreach { mask =>
      val num = mask.toBinaryString.count(_ == '1')
      (0 until n).foreach { i =>
        if (
          (mask & (1 << i)) > 0 && ((i + 1) % num == 0 || num % (i + 1) == 0)
        ) {
          dp(mask) += dp(mask ^ (1 << i))
        }
      }
    }
    dp.last
  }
}
