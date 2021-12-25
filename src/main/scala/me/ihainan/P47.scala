package me.ihainan

object P47 {
  def permuteUnique(nums: Array[Int]): List[List[Int]] = {
    val ans = collection.mutable.ListBuffer.empty[List[Int]]
    val path = new Array[Int](nums.length)
    val used = collection.mutable.Set.empty[Int]

    def dfs(i: Int): Unit = {
      if (i == nums.length) ans += path.toList
      else {
        val set = collection.mutable.Set.empty[Int]
        nums.indices.foreach { j =>
          if (!used(j) && !set(nums(j))) {
            set += nums(j)
            used += j
            path(i) = nums(j)
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
