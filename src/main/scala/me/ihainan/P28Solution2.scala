package me.ihainan

object P28Solution2 {
  val MOD = 1 << 28

  def mod(v: Int) = (v + MOD) % MOD

  def strStr(haystack: String, needle: String): Int = {
    val (m, n) = (haystack.length, needle.length)
    if (n == 0) 0
    else if (n > m) -1
    else {
      var p = 1
      (0 until n - 1).foreach(_ => p = mod(p * 26))

      var h = 0
      (0 until n).foreach(i => h = mod(mod(h * 26) + needle(i) - 'a'))

      var h2 = 0
      (0 until n).foreach(i => h2 = mod(mod(h2 * 26) + haystack(i) - 'a'))
      if (h2 == h && haystack.substring(0, n) == needle) return 0
      (1 to m - n).foreach { i =>
        h2 = mod(h2 - mod(p * (haystack(i - 1) - 'a')))
        h2 = mod(mod(h2 * 26) + haystack(i + n - 1) - 'a')
        if (h2 == h && haystack.substring(i, i + n) == needle) return i
      }

      -1
    }
  }
}
