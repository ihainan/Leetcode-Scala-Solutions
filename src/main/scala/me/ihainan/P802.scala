package me.ihainan

object P802 {
  import collection.mutable

  def eventualSafeNodes(graph: Array[Array[Int]]): List[Int] = {
    val whitelist = mutable.Set.empty[Int]
    val blacklist = mutable.Set.empty[Int]

    def dfs(current: Int, path: List[Int], visited: Set[Int]): Boolean = {
      if (whitelist(current)) true
      else if (blacklist(current) || visited(current)) {
        path.foreach { node => blacklist += node }
        false
      } else if (graph(current).forall(next => dfs(next, path :+ current, visited + current))) {
          whitelist += current
          true
      } else false
    }

    graph.indices.filter { current => dfs(current, Nil, Set.empty[Int]) }.toList
  }
}