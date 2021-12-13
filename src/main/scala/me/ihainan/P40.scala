package me.ihainan

object P40 {
  def combinationSum2(candidates: Array[Int], target: Int): List[List[Int]] = {
    val ans = collection.mutable.ListBuffer.empty[List[Int]]   
    val path = collection.mutable.ArrayDeque.empty[Int]
    val sorted = candidates.sorted
    val used = collection.mutable.Set.empty[Int]
    
    def dfs(i: Int, sum: Int): Unit = {
      if (i == sorted.length) {
        if (sum == target) ans += path.toList
      } else {
        if (sum <= target) {
          dfs(i + 1, sum) 
          if (!(i > 0 && sorted(i) == sorted(i - 1) && !used(i - 1))) {
            used += i
            path.append(sorted(i))
            dfs(i + 1, sum + sorted(i))
            path.removeLast()
            used -= i
          }
        }
      }
    }

    dfs(0, 0)
    ans.toList
  }
}