package me.ihainan

object P397 {
  def integerReplacement(n: Int): Int = {
    val memo = collection.mutable.Map.empty[Int, Int].withDefaultValue(0)
    val max = n

    def dfs(n: Int): Int = {
      if (n == 1) 0
      else if (memo.isDefinedAt(n)) memo(n)
      else {
        val v =
          if (n % 2 == 0) dfs(n >>> 1) + 1
          else dfs((n + 1) >>> 1).min(dfs((n - 1) >>> 1)) + 2
        memo(n) = v
        memo(n)
      }
    }

    dfs(n)
    memo(n)
  }
}
