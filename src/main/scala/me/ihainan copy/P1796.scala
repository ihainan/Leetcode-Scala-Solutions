package me.ihainan

object P1796 {
  def secondHighest(s: String): Int = {
    var (max, mmax) = (-1, -1)
    s.foreach { c =>
      if (Character.isDigit(c)) {
        val num = c - '0'
        if (num > max) {
          mmax = max
          max = num
        } else if (num != max && num > mmax) mmax = num
      }
    }
    mmax
  }
}