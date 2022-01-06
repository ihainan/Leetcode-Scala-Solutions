package me.ihainan

object P1427 {
  def stringShift(s: String, shift: Array[Array[Int]]): String = {
    var start = 0
    shift.foreach { case Array(direction, amount) =>
      val mul = if (direction == 0) 1 else -1
      start = (start + mul * amount + s.length) % s.length
    }
    while (start < 0) start = (start + s.length) % s.length
    if (start == 0) s
    else s.substring(start, s.length) + s.substring(0, start)
  }
}
