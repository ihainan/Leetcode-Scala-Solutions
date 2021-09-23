package me.ihainan

object LCS01 {
  def leastMinutes(n: Int): Int = {
    var days = 1
    var speed = 1
    while (speed < n) {
      speed *= 2
      days += 1
    }
    days
  }
}