package me.ihainan

object P1220 {
  def countVowelPermutation(n: Int): Int = {
    val MOD = (1e9 + 7).toInt

    def mod(x: Int) = ((x.toLong + MOD) % MOD).toInt

    val map = "aeiou".zipWithIndex.toMap
    var dp = Array.fill(5)(1)
    (2 to n).foreach { _ =>
      val tp = new Array[Int](5)
      tp(map('a')) = mod(tp(map('a')) + dp(map('u')))
      tp(map('a')) = mod(tp(map('a')) + dp(map('i')))
      tp(map('a')) = mod(tp(map('a')) + dp(map('e')))

      tp(map('e')) = mod(tp(map('e')) + dp(map('a')))
      tp(map('e')) = mod(tp(map('e')) + dp(map('i')))

      tp(map('i')) = mod(tp(map('i')) + dp(map('e')))
      tp(map('i')) = mod(tp(map('i')) + dp(map('o')))

      tp(map('o')) = mod(tp(map('o')) + dp(map('i')))

      tp(map('u')) = mod(tp(map('u')) + dp(map('o')))
      tp(map('u')) = mod(tp(map('u')) + dp(map('i')))

      dp = tp
    }
    var ans = 0
    dp.indices.foreach(i => ans = mod(ans + dp(i)))
    ans
  }
}
