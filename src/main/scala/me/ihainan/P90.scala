package me.ihainan

object P90 {
  def subsetsWithDup(nums: Array[Int]): List[List[Int]] = {
    val ans = collection.mutable.ListBuffer.empty[List[Int]]
    val path = collection.mutable.ArrayDeque.empty[Int]
    val sorted = nums.sorted

    def dfs(i: Int, preUse: Boolean): Unit = {
      if (i == sorted.length) ans += path.toList
      else {
        dfs(i + 1, false)
        if (!(i > 0 && sorted(i) == sorted(i - 1) && !preUse)) {
          path.append(sorted(i))
          dfs(i + 1, true)
          path.removeLast()
        }
      }
    }

    dfs(0, false)
    ans.toList
  }
}
