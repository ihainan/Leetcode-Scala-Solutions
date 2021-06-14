package me.ihainan

object P347 {
  def guess(num: Int): Int = 0

  def guessNumber(n: Int): Int = {
    def find(l: Int, r: Int): Int = {
      val mid = (l + r) >>> 1
      val guessResult = guess(mid)
      if (guessResult == 0) mid
      else if (guessResult == 1) find(mid + 1, r)
      else find(l, mid - 1)
    }

    find(1, n)
  }
}