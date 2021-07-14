package me.ihainan

object P274Solution2 {
  def hIndex(citations: Array[Int]): Int = {
    val len = citations.length
    val counter = new Array[Int](len + 1)
    citations.foreach { c => if (c > len) counter(len) += 1 else counter(c) += 1 }
    var sum = 0
    (len to 0 by -1).foreach { i =>
      sum += counter(i)
      if (sum >= i) return i
    }
    0
  }
}
