package me.ihainan

object P77 {
  def combine(n: Int, k: Int): List[List[Int]] = {
    val ans = collection.mutable.ListBuffer.empty[List[Int]]
    val path = new Array[Int](k)

    def dfs(i: Int, count: Int): Unit = {
      if (count + n - i >= k) {
        if (count == k) ans += path.toList
        else {
          path(count) = i + 1
          dfs(i + 1, count + 1)
          dfs(i + 1, count)
        }
      }
    }

    dfs(0, 0)
    ans.toList
  }
}
