package me.ihainan

object P1743 {
  def restoreArray(adjacentPairs: Array[Array[Int]]): Array[Int] = {
    val ans = collection.mutable.ArrayBuffer.empty[Int]
    val map = collection.mutable.Map.empty[Int, Set[Int]].withDefaultValue(Set.empty[Int])

    adjacentPairs.foreach { case pair =>
      map(pair(0)) = map(pair(0)) + pair(1)
      map(pair(1)) = map(pair(1)) + pair(0)
    }

    val size = map.size
    val first = map.collectFirst {
      case (k, v) if v.size <= 1 => k
    }.getOrElse(return Array.empty[Int])
    val queue = collection.mutable.Queue(first)
    while (queue.nonEmpty) {
      val current = queue.dequeue
      ans += current
      map(current).foreach { next =>
        map(next) = map(next) - current
        queue.enqueue(next)
      }
    }

    ans.toArray
  }
}