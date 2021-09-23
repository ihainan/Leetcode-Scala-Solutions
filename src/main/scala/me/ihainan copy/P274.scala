package me.ihainan

object P274 {
  def hIndex(citations: Array[Int]): Int = {
    val sorted = citations.sorted
    sorted.indices.foreach { i =>
      val num = sorted.length - i
      if (sorted(i) >= num) return num
    }
    0
  }
}
