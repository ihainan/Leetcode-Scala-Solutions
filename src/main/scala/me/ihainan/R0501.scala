package me.ihainan

object R0501 {
  def insertBits(N: Int, M: Int, i: Int, j: Int): Int = {
    val num = (i to j).foldLeft(N) { case (num, k) => num & (~(1 << k)) }
    num | (M << i)
  }
}