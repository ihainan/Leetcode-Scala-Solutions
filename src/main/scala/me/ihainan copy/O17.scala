package me.ihainan

object O17 {
  def printNumbers(n: Int): Array[Int] = {
    (1 until math.pow(10, n).toInt).toArray
  }
}