package me.ihainan

object R1611 {
  def divingBoard(shorter: Int, longer: Int, k: Int): Array[Int] = {
    if (k == 0) Array.empty[Int]
    else if (shorter == longer) Array(shorter * k)
    else (k to 0 by -1).map { i => shorter * i + (k - i) * longer }.toArray
  }
}