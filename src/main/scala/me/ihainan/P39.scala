package me.ihainan

object P39 {
  def combinationSum(candidates: Array[Int], target: Int): List[List[Int]] = {
    val path = collection.mutable.ListBuffer.empty[Int]
    val ans = collection.mutable.ListBuffer.empty[List[Int]]

    def dfs(sum: Int, start: Int): Unit = {
      if (sum >= target) {
        if (sum == target) ans += path.toList
      } else {
        (start until candidates.length).foreach { i =>
          path += candidates(i)
          dfs(sum + candidates(i), i)
          path.dropRightInPlace(1)
        }
      }
    }

    dfs(0, 0)
    ans.toList
  }
}
