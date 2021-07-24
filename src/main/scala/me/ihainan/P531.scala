package me.ihainan

object P531 {
  def findLonelyPixel(picture: Array[Array[Char]]): Int = {
    val (m, n) = (picture.length, picture.head.length)
    val rows = new Array[Int](m)
    val columns = new Array[Int](n)
    var ans = 0

    (0 until m).foreach { i =>
      (0 until n).foreach { j =>
        if (picture(i)(j) == 'B') {
          rows(i) += 1
          columns(j) += 1
        }
      }
    }

    for {
      i <- 0 until m if rows(i) == 1
      j <- 0 until n if columns(j) == 1 && picture(i)(j) == 'B'
    } ans += 1

    ans
  }
}