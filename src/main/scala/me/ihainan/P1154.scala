package me.ihainan

object P1154 {
  def dayOfYear(date: String): Int = {
    val split = date.split("-")
    val (y, m, d) = (split(0).toInt, split(1).toInt, split(2).toInt)
    val days = Array(0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
    if ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0) days(2) += 1
    var ans = 0
    (1 to m - 1).foreach(i => ans += days(i))
    ans += d
    ans
  }
}