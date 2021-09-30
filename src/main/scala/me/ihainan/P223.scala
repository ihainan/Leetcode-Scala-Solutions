package me.ihainan

object P223 {
  def computeArea(
      ax1: Int,
      ay1: Int,
      ax2: Int,
      ay2: Int,
      bx1: Int,
      by1: Int,
      bx2: Int,
      by2: Int
  ): Int = {
    val area1 = (ax2 - ax1) * (ay2 - ay1)
    val area2 = (bx2 - bx1) * (by2 - by1)
    val overLapWidth = ((ax2 min bx2) - (ax1 max bx1)) max 0
    val overLapHeight = ((ay2 min by2) - (ay1 max by1)) max 0
    area1 + area2 - overLapWidth * overLapHeight
  }
}
