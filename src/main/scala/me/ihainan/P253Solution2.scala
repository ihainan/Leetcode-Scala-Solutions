package me.ihainan

object P253Solution2 {
  def minMeetingRooms(intervals: Array[Array[Int]]): Int = {
    val sorted = intervals.sortWith { case (v1, v2) =>
      v1(1) < v2(1) || (v1(1) == v2(1) && v1(0) < v2(0))
    }

    val queue = collection.mutable.PriorityQueue.empty[Int]
    val tmp = collection.mutable.ListBuffer.empty[Int]
    sorted.foreach { interval =>
      while (queue.nonEmpty && queue.head > interval(0)) tmp += queue.dequeue
      if (queue.nonEmpty) queue.dequeue // we will update this value
      queue += interval(1)
      tmp.foreach { t => queue.enqueue(t) }
      tmp.clear()
    }
    queue.size
  }
}