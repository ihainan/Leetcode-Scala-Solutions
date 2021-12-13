package me.ihainan

object P47Solution2 {
  def permuteUnique(nums: Array[Int]): List[List[Int]] = {
    val ans = collection.mutable.ListBuffer.empty[List[Int]]
    val path = new Array[Int](nums.length)
    val used = collection.mutable.Set.empty[Int]
    val sorted = nums.sorted
    
    def dfs(i: Int): Unit = {
      if (i == nums.length) ans += path.toList
      else {
        nums.indices.foreach { j =>
          if (!used(j) && !(j > 0 && sorted(j) == sorted(j - 1) && !used(j - 1))) {
            used += j
            path(i) = sorted(j)
            dfs(i + 1)
            used -= j
          }
        }
      }
    }

    dfs(0)
    ans.toList
  }
}