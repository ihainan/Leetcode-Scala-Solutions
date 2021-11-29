package me.ihainan

object P784 {
  def letterCasePermutation(s: String): List[String] = {
    val indices = s.indices.filter(i => Character.isAlphabetic(s(i))).toArray
    val ans = collection.mutable.ListBuffer.empty[String]
    val chars = s.toCharArray

    def dfs(depth: Int): Unit = {
      if (depth == indices.length) ans += new String(chars)
      else {
        dfs(depth + 1)
        val c = s(indices(depth))
        chars(indices(depth)) =
          if (Character.isUpperCase(c)) Character.toLowerCase(c)
          else Character.toUpperCase(c)
        dfs(depth + 1)
        chars(indices(depth)) = c
      }
    }

    dfs(0)
    ans.toList
  }
}
