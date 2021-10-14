package me.ihainan

object P1306 {
  def canReach(arr: Array[Int], start: Int): Boolean = {
    val set = collection.mutable.Set.empty[Int]

    def dfs(i: Int): Boolean = {
      if (i < 0 || i >= arr.length) false
      else if (arr(i) == 0) true
      else if (set(i)) false
      else {
        set += i
        dfs(i - arr(i)) || dfs(i + arr(i))
      }
    }

    dfs(start)
  }
}