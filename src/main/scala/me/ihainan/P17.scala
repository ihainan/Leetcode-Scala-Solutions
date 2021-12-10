package me.ihainan

object P17 {
  def letterCombinations(digits: String): List[String] = {
    if (digits.length == 0) return Nil
    val ans = collection.mutable.ListBuffer.empty[String]
    val chars = new Array[Char](digits.length)
    val map =
      Array("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")

    def dfs(i: Int): Unit = {
      if (i == digits.length) ans += new String(chars)
      else {
        map(digits(i) - '0').foreach { c =>
          chars(i) = c
          dfs(i + 1)
        }
      }
    }

    dfs(0)
    ans.toList
  }
}
