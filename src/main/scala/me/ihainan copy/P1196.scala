package me.ihainan

object P1196 {
  def maxNumberOfApples(arr: Array[Int]): Int = {
    val sorted = arr.sorted
    var sum = 5000
    sorted.indices.foreach { i => if (sum < sorted(i)) return i else sum -= sorted(i) }
    sorted.length
  }
}