package me.ihainan

object P258 {
  def addDigits(num: Int): Int = {
    val m = num % 9
    if (m != 0) m
    else if (num == 0) 0
    else 9
  }
}
