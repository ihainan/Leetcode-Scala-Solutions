package me.ihainan

object R1610 {
  def maxAliveYear(birth: Array[Int], death: Array[Int]): Int = {
    val diff = new Array[Int](2002)
    birth.indices.foreach { i =>
      diff(birth(i)) += 1
      diff(death(i) + 1) -= 1
    }

    var (v, max, year) = (0, 0, 0)
    (1900 to 2000).foreach { i =>
      v = v + diff(i)
      if (v > max) {
        max = v
        year = i
      }
    }
    year
  }
}