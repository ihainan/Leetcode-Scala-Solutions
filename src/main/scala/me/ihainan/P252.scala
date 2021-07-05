package me.ihainan

object P252 {
  def canAttendMeetings(intervals: Array[Array[Int]]): Boolean = {
    val sorted = intervals.sortBy(_.apply(1))
    !(0 until sorted.length - 1).exists { i =>
      sorted(i)(1) > sorted(i + 1)(0)
    }
  }
}