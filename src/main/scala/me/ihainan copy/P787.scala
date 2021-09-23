package me.ihainan

object P787 {
  def findCheapestPrice(
      n: Int,
      flights: Array[Array[Int]],
      src: Int,
      dst: Int,
      k: Int
  ): Int = {
    val map =
      collection.mutable.Map.empty[Int, List[(Int, Int)]].withDefaultValue(Nil)
    flights.foreach(f => map(f(0)) = map(f(0)) :+ (f(1), f(2)))

    val distance = Array.fill(n)(Int.MaxValue)
    distance(src) = 0

    val queue = collection.mutable.Queue((src, 0))
    var step = 0
    while (queue.nonEmpty && step <= k) {
      val nodes = queue.indices.map(_ => queue.dequeue)
      step += 1
      nodes.foreach { case (node, dist) =>
        map(node).foreach { case (next, cost) =>
          if (dist + cost < distance(next)) {
            distance(next) = dist + cost
            queue.enqueue((next, distance(next)))
          }
        }
      }
    }

    if (distance(dst) == Int.MaxValue) -1 else distance(dst)
  }
}
