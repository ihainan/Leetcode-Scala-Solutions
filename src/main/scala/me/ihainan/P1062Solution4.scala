package me.ihainan

object P1062Solution4 {
  val MOD = 1 << 24
  def mod(v: Int) = (v + MOD) % MOD

  def longestRepeatingSubstring(s: String): Int = {

    def hasDuplicate(m: Int): Boolean = {
      val set = collection.mutable.Set.empty[Int]
      var (p, h) = (1, 0)
      (1 until m).foreach(_ => p = mod(p * 26)) // pow(26, m - 1)
      (0 until m).foreach(i => h = mod(mod(h * 26) + s(i) - 'a'))
      set += h

      (1 to s.length - m).foreach { i =>
        h = mod(h - mod(p * (s(i - 1) - 'a')))
        h = mod(mod(h * 26) + s(i + m - 1) - 'a')
        if (set(h)) return true
        set += h
      }

      false
    }

    @annotation.tailrec
    def find(l: Int, r: Int): Int = {
      if (l > r) 0
      else if (hasDuplicate(r)) r
      else {
        val m = (l + r) >>> 1
        if (hasDuplicate(m)) find(m, r - 1) else find(l, m - 1)
      }
    }

    find(1, s.length)
  }
}
