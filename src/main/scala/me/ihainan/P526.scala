package me.ihainan

object P526 {
  def countArrangement(n: Int): Int = {
    val set = collection.mutable.Set.empty[Int]
    var ans = 0

    def dfs(depth: Int): Unit = {
      if (depth == n + 1) ans += 1
      else {
        (1 to n).foreach { num =>
          if (!set(num) && (num % depth == 0 || depth % num == 0)) {
            set += num
            dfs(depth + 1)
            set -= num
          }
        }
      }
    }

    dfs(1)
    ans
  }
}