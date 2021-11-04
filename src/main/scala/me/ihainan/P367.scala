package me.ihainan

object P367 {
  def isPerfectSquare(num: Int): Boolean = {
    @annotation.tailrec
    def find(l: Int, r: Int): Int = {
      if (l > r) -1
      else if (l.toLong * l >= num) l
      else {
        val m = (l + r) >>> 1
        if (m.toLong * m >= num) find(l + 1, m) else find(m + 1, r)
      }
    }

    val ans = find(1, Int.MaxValue)
    ans != -1 && ans * ans == num
  }
}
