package me.ihainan

object P296Solution3 {
  def minTotalDistance(grid: Array[Array[Int]]): Int = {
    val (m, n) = (grid.length, grid.head.length)
    val rows = collection.mutable.ArrayBuffer.empty[Int]
    val columns = collection.mutable.ArrayBuffer.empty[Int]
    for {
      i <- 0 until m
      j <- 0 until n if (grid(i)(j) == 1)
    } rows += i

    for {
      j <- 0 until n
      i <- 0 until m if (grid(i)(j) == 1)
    } columns += j

    val (x, y) = (rows((rows.length - 1) / 2), columns((columns.length - 1) / 2))
    var ans = 0
    for {
      i <- 0 until m
      j <- 0 until n if (grid(i)(j) == 1)
    } ans += (x - i).abs + (y - j).abs
    ans
  }
}