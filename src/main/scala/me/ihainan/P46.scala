package me.ihainan

object P46 {
  def permute(nums: Array[Int]): List[List[Int]] = {
    val ans = collection.mutable.ListBuffer.empty[List[Int]]
    val path = new Array[Int](nums.length)
    val seen = new Array[Boolean](nums.length)

    def dfs(i: Int): Unit = {
      if (i == nums.length) ans += path.toList
      else {
        nums.indices.foreach { j =>
          if (!seen(j)) {
            seen(j) = true
            path(i) = nums(j)
            dfs(i + 1)
            seen(j) = false
          }
        }
      }
    }

    dfs(0)
    ans.toList
  }
}
