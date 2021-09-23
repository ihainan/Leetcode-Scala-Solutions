package me.ihainan

object P582 {
  import collection.mutable.ListBuffer

  def killProcess(pid: List[Int], ppid: List[Int], kill: Int): List[Int] = {
    val children = collection.mutable.Map.empty[Int, ListBuffer[Int]]
    val ans = collection.mutable.Set.empty[Int]
    ppid.zip(pid).foreach { case (p, c) =>
      if (!children.isDefinedAt(p)) children(p) = ListBuffer.empty[Int]
      children(p) += c
    }

    def dfs(current: Int): Unit = {
      if (!ans(current)) {
        ans += current
        if (children.isDefinedAt(current))
          children(current).foreach { child => dfs(child) }
      }
    }

    dfs(kill)
    ans.toList
  }
}
