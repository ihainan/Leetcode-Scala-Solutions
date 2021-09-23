package me.ihainan

object P1109 {
  def corpFlightBookings(bookings: Array[Array[Int]], n: Int): Array[Int] = {
    val diff = new Array[Int](n + 1)
    bookings.foreach { booking =>
      diff(booking(0) - 1) += booking(2)
      diff(booking(1)) -= booking(2)
    }

    println(diff.mkString(", "))

    var k = 0
    (0 until n).map { i =>
      k += diff(i)
      k
    }.toArray
  }
}