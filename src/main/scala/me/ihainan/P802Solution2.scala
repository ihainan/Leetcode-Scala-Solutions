package me.ihainan

object P802Solution2 {
  def eventualSafeNodes(graph: Array[Array[Int]]): List[Int] = {
    val colors = new Array[Int](graph.length)

    def isSafe(current: Int): Boolean = {
      if (colors(current) == 2) true
      else if (colors(current) == 1) false
      else {
        colors(current) = 1
        if (graph(current).forall(next => isSafe(next))) {
          colors(current) = 2
          true
        } else false
      }
    }

    graph.indices.filter(isSafe).toList
  }
}