package me.ihainan

object P797 {
  def allPathsSourceTarget(graph: Array[Array[Int]]): List[List[Int]] = {
    val ans = collection.mutable.ListBuffer.empty[List[Int]]
    val path = collection.mutable.ArrayDeque(0)

    def visit(): Unit = {
      if (path.last == graph.length - 1) ans += path.toList
      else
        graph(path.last).foreach { next =>
          path += next
          visit()
          path.removeLast()
        }
    }

    visit()
    ans.toList
  }
}
