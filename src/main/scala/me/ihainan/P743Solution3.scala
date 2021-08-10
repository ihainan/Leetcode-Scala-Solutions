package me.ihainan

object P743Solution3 {
  def networkDelayTime(times: Array[Array[Int]], n: Int, k: Int): Int = {
    val ordering = Ordering[Int].on { v: (Int, Int) => -v._2 }
    val queue = collection.mutable.PriorityQueue.empty[(Int, Int)](ordering)
    val edges = collection.mutable.Map.empty[Int, List[(Int, Int)]].withDefaultValue(Nil)
    val distance = Array.fill(n)(Int.MaxValue)
    times.foreach( time => edges(time(0) - 1) = edges(time(0) - 1) :+ ((time(1) - 1, time(2))) )
    distance(k - 1) = 0
    queue.enqueue((k - 1, 0))
    while (queue.nonEmpty) {
      val (current, currentTime) = queue.dequeue
      if (currentTime <= distance(current)) {
        edges(current).foreach { case (next, time) =>
          if (distance(next) > currentTime + time) {
            distance(next) = currentTime + time
            queue.enqueue((next, distance(next)))
          }
        }
      }
    }
  
    val max = distance.max
    if (max == Int.MaxValue) -1 else max
  }
}