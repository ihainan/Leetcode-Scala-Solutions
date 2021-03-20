package me.ihainan

object R1616 {
  def subSort(array: Array[Int]): Array[Int] = {
    val sorted = array.sorted
    val left = sorted.indices.collectFirst { case i if array(i) != sorted(i) => i }.getOrElse(-1)
    val right = sorted.indices.reverse.collectFirst { case i if array(i) != sorted(i) => i }.getOrElse(-1)
    Array(left, right)
  }
}