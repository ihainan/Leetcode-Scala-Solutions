package me.ihainan

object O17Solution2 {

  import collection.mutable.ArrayBuffer

  def printNumbers(n: Int): Array[Int] = {
    val ans = ArrayBuffer.empty[Int]
    dfs(0, "", n, ans)
    ans.toArray
  }

  def dfs(depth: Int, str: String, n: Int, ans: ArrayBuffer[Int]): Unit = {
    if (depth == n) {
      if (str.toInt != 0) ans += str.toInt
    } else {
      (0 to 9).foreach { i =>
        dfs(depth + 1, str + i, n, ans)
      }
    }
  }
}