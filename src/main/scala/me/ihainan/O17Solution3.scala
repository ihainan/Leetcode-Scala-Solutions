package me.ihainan

object O17Solution3 {

  import collection.mutable.ArrayBuffer

  def printNumbers(n: Int): Array[String] = {
    val ans = ArrayBuffer.empty[String]
    val chars = (0 to 9).map { i => ('0' + i).toChar }.toArray
    val nums = new Array[Char](n)

    def dfs(depth: Int, start: Int): Unit = {
      if (depth == n) {
        if (start != -1) ans += nums.slice(start, nums.length).mkString
      } else {
        (0 to 9).foreach { i =>
          if (i == 0 && start == -1) dfs(depth + 1, start)
          else {
            nums(depth) = chars(i)
            if (start != -1) dfs(depth + 1, start)
            else dfs(depth + 1, depth)
          }
        }
      }
    }

    dfs(0, -1)
    ans.toArray
  }

  def main(args: Array[String]): Unit = {
    println(printNumbers(2).mkString(", "))
  }
}