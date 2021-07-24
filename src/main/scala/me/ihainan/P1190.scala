package me.ihainan

object P1190 {
  def corpFlightBookings(bookings: Array[Array[Int]], n: Int): Array[Int] = {
    val diff = new Array[Int](n + 1)
    bookings.foreach { booking =>
      diff(booking(0) - 1) += booking(2)
      diff(booking(1)) -= booking(2)
    }

    var current = 0
    (0 until n).map { i => current += diff(i); current }.toArray
  }
}