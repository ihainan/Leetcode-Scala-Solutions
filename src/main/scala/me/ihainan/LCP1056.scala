package me.ihainan

object LCP1056 {
  def confusingNumber(N: Int): Boolean = {
    val str = N.toString
    val map = Map('0' -> '0', '1' -> '1', '6' -> '9', '8' -> '8', '9' -> '6')
    val str2 = str.reverse.map { c => if (map.isDefinedAt(c)) map(c) else return false }
    str != str2
  }
}