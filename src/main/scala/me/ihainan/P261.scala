package me.ihainan

object P261 {
  def validTree(n: Int, edges: Array[Array[Int]]): Boolean = {
    val map = collection.mutable.Map.empty[Int, Set[Int]].withDefaultValue(Set.empty[Int])
    edges.foreach { edge => map(edge(0)) = map(edge(0)) + edge(1); map(edge(1)) = map(edge(1)) + edge(0) }

    if (n != 1 && (0 until n).exists(i => map(i).isEmpty)) return false

    val queue = collection.mutable.Queue(0)
    val set = collection.mutable.Set(0)
    while (queue.nonEmpty) {
      val nodes = queue.indices.map(_ => queue.dequeue)
      nodes.foreach { node =>
        map(node).foreach { next =>
          if (set(next)) return false
          map(next) = map(next) - node
          map(node) = map(node) - next
          set += next
          queue.enqueue(next)
        }
      }
    }
    !map.exists(_._2.nonEmpty)
  }
}