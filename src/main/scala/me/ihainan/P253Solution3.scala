package me.ihainan

object P253Solution3 {
  def minMeetingRooms(intervals: Array[Array[Int]]): Int = {
    val sorted = intervals.sortWith { case (v1, v2) => v1(0) < v2(0) || (v1(0) == v2(0) && v1(1) < v2(1)) }
    val queue = collection.mutable.PriorityQueue.empty[Int](Ordering.Int.reverse)
    sorted.foreach { interval =>
      if (queue.nonEmpty && queue.head <= interval(0)) queue.dequeue
      queue.enqueue(interval(1))
    }
    queue.size
  }
}