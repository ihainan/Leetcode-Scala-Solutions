package me.ihainan

import scala.collection.mutable.{Map, Queue, Set}

object R0401_BFS {
  def findWhetherExistsPath(n: Int, graph: Array[Array[Int]], start: Int, target: Int): Boolean = {
    // init map
    val map = Map.empty[Int, Set[Int]]
    graph.foreach { edge => if (map.isDefinedAt(edge(0))) map(edge(0)) += edge(1) else map(edge(0)) = Set(edge(1)) }

    // bfs
    val queue = Queue.empty[Int]
    val visited = Set.empty[Int]
    queue.enqueue(start)
    while (queue.nonEmpty) {
      val cur = queue.dequeue
      visited += cur
      if (map.isDefinedAt(cur)) {
        map(cur).foreach { next =>
          if (next == target) return true
          if (!visited(next)) queue.enqueue(next)
        }
      }
    }
    false
  }
}
