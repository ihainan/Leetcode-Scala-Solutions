package me.ihainan

object P22 {
  def generateParenthesis(n: Int): List[String] = {
    val ans = collection.mutable.ListBuffer.empty[String]
    val chars = new Array[Char](n * 2)

    def dfs(i: Int, l: Int, r: Int): Unit = {
      if (l == 0 && r == 0) {
        ans += new String(chars)
      } else {
        if (l != 0) {
          chars(i) = '('
          dfs(i + 1, l - 1, r)
        }
        if (r != 0 && l < r) {
          chars(i) = ')'
          dfs(i + 1, l, r - 1)
        }
      }
    }

    dfs(0, n, n)
    ans.toList
  }
}
