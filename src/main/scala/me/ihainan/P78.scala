package me.ihainan

object P78 {
  def subsets(nums: Array[Int]): List[List[Int]] = {
    val ans = collection.mutable.ListBuffer.empty[List[Int]]
    val path = collection.mutable.ArrayDeque.empty[Int]

    def dfs(i: Int): Unit = {
      if (i == nums.length) ans += path.toList
      else {
        path.append(nums(i))
        dfs(i + 1)
        path.removeLast()
        dfs(i + 1)
      }
    }

    dfs(0)
    ans.toList
  }
}
