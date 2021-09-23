package me.ihainan

object R1607 {
  def maximum(a: Int, b: Int): Int = {
    val k = ((a.toLong - b.toLong) >>> 63).toInt
    (k ^ 1) * a + k * b
  }
}