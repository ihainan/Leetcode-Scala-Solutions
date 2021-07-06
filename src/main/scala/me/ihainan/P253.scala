package me.ihainan

object P253 {
  def minMeetingRooms(intervals: Array[Array[Int]]): Int = {
    val sorted = intervals.sortWith { case (v1, v2) =>
      v1(1) < v2(1) || (v1(1) == v2(1) && v1(0) < v2(0))
    }

    val rooms = collection.mutable.ListBuffer.empty[Int]
    sorted.foreach { interval =>
      var (max, i) = (-1, -1)
      rooms.indices.foreach { j =>
        if (rooms(j) <= interval(0) && rooms(j) > max) {
          i = j
          max = rooms(j)
        }
      }
      if (i != -1) rooms(i) = interval(1)
      else rooms += interval(1)
    }
    rooms.size
  }
}