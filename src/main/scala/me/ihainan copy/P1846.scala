package me.ihainan

object P1846 {
  def maximumElementAfterDecrementingAndRearranging(arr: Array[Int]): Int = {
    val sorted = arr.sorted
    sorted(0) = 1
    (1 until sorted.length).foreach { i => if (sorted(i) > sorted(i - 1) + 1) sorted(i) = sorted(i - 1) + 1 }
    sorted.last
  }
}