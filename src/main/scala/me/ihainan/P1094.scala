package me.ihainan

object P1094 {
  def carPooling(trips: Array[Array[Int]], capacity: Int): Boolean = {
    val max = trips.map(_.apply(2)).max
    val diff = new Array[Int](max + 1)
    trips.foreach { trip =>
      diff(trip(1)) += trip(0)
      diff(trip(2)) -= trip(0)
    }

    var current = 0
    !(0 to max).exists { i => current += diff(i); current > capacity }
  }
}