package me.ihainan

object P802 {
  def eventualSafeNodes(graph: Array[Array[Int]]): List[Int] = {
    val ans = collection.mutable.ListBuffer.empty[Int]
    val blacklist = collection.mutable.Set.empty[Int]
    val whitelist = collection.mutable.Set.empty[Int]
    val path = collection.mutable.ListBuffer.empty[Int]
    val visited = collection.mutable.Set.empty[Int]

    def dfs(current: Int): Boolean = {
      if (whitelist(current)) true
      else if (visited(current) || blacklist(current)) {
        path.foreach { node => blacklist += node }
        false
      } else {
        path += current
        visited += current
        val res = graph(current).forall(next => dfs(next))
        if (res) whitelist += current
        visited -= current
        path -= current
        res
      }
    }

    graph.indices.foreach { current =>
      path.clear()
      visited.clear()
      if (dfs(current)) ans += current
    }

    ans.toList
  }
}