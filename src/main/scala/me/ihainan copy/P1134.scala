package me.ihainan

object P1134 {
  def isArmstrong(n: Int): Boolean = {
    val len = n.toString.length
    n.toString.map { c => math.pow(c - '0', len).toInt }.sum == n
  }
}