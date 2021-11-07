package me.ihainan

object P598 {
  def maxCount(m: Int, n: Int, ops: Array[Array[Int]]): Int = {
    var (maxX, maxY) = (m, n)
    ops.foreach { case Array(i, j) =>
      maxX = maxX.min(i)
      maxY = maxY.min(j)
    }
    maxX * maxY
  }
}