package me.ihainan

object P786Solution4 {
  def kthSmallestPrimeFraction(arr: Array[Int], k: Int): Array[Int] = {
    val fractions = 
      (0 until arr.length - 1).map { i =>
        (arr.length - 1 to i + 1 by -1).map(j => Array(arr(i), arr(j))).toArray
      }.toArray

    val indices = new Array[Int](arr.length - 1)
    var current = 0

    def merge(): Array[Int] = {
      var (min, minIndex) = (Double.MaxValue, 0)
      indices.indices.foreach { i =>
        if (indices(i) != fractions(i).length) {
          val v = fractions(i)(indices(i))(0) * 1.0 / fractions(i)(indices(i))(1)
          if (v < min) {
            min = v
            minIndex = i
          }
        }
      }
      indices(minIndex) += 1
      fractions(minIndex)(indices(minIndex) - 1)
    }

    (0 until k).foreach { i =>
      val v = merge()
      if (i == k - 1) return v
    }

    Array.empty[Int]
  }
}
