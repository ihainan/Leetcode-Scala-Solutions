package me.ihainan

object P1997 {
  val MOD = (1e9 + 7).toInt

  def firstDayBeenInAllRooms(nextVisit: Array[Int]): Int = {
    val sum = Array.fill(nextVisit.length - 1)(0)
    var current = 0
    (0 until nextVisit.length - 1).foreach { i =>
      val v =
        if (nextVisit(i) == i) 2
        else if (nextVisit(i) == 0) sum(i - 1) + 2
        else sum(i - 1) - sum(nextVisit(i) - 1) + 2
      current = ((v.toLong + current + MOD) % MOD).toInt
      sum(i) = current
    }

    current
  }
}
