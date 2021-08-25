package me.ihainan

object P787 {
  import collection.mutable


  /**
   * BFS，需要纪录当前结点的距离，注意不能用 
   **/
  def findCheapestPrice(
      n: Int,
      flights: Array[Array[Int]],
      src: Int,
      dst: Int,
      k: Int
  ): Int = {
    val distance = Array.fill(n)(Int.MaxValue)
    val map = mutable.Map.empty[Int, List[(Int, Int)]].withDefaultValue(Nil)
    flights.foreach(f => map(f(0)) = map(f(0)) :+ (f(1), f(2)))
    distance(src) = 0
    var ans = -1
    val queue = mutable.Queue((src, 0))
    var step = 0
    while (queue.nonEmpty && step <= k) {
      val nodes = queue.indices.map(_ => queue.dequeue)
      step += 1
      nodes.foreach { case (node, nodeDis) =>
        map(node).foreach { case (next, dist) =>
          if (nodeDis + dist < distance(next)) {
            distance(next) = nodeDis + dist
            queue.enqueue((next, nodeDis + dist))
          }
        }
      }
    }

    if (distance(dst) == Int.MaxValue) -1 else distance(dst)
  }
}
