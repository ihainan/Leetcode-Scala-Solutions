package me.ihainan

object P851 {
  def loudAndRich(richer: Array[Array[Int]], quiet: Array[Int]): Array[Int] = {
    val map = collection.mutable.Map.empty[Int, List[Int]].withDefaultValue(Nil)
    richer.foreach { case Array(v1, v2) =>
      map(v2) = map(v2) :+ v1
    }

    val ans = Array.fill(quiet.length)(-1)

    def dfs(i: Int): Unit = {
      if (ans(i) == -1) {
        ans(i) = i
        map(i).foreach { j =>
          dfs(j)
          if (quiet(ans(j)) < quiet(ans(i))) ans(i) = ans(j)
        }
      }
    }

    quiet.indices.foreach { i => dfs(i) }
    ans
  }
}
