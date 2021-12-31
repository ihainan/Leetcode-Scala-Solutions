package me.ihainan

object P973 {
  def kClosest(points: Array[Array[Int]], k: Int): Array[Array[Int]] = {
    val dis = points.map { case Array(x, y) => x * x + y * y }.zipWithIndex

    def swap(i: Int, j: Int): Unit = {
      val tmp = dis(i)
      dis(i) = dis(j)
      dis(j) = tmp
    }

    def quickSort(l: Int, r: Int): Unit = {
      if (l < r) {
        val tmp = dis(l)
        var (i, j) = (l, r)
        while (i < j) {
          while (i < j && dis(j)._1 > tmp._1) j -= 1
          while (i < j && dis(i)._1 <= tmp._1) i += 1
          swap(i, j)
        }
        swap(l, i)
        if (i < k - 1) quickSort(i + 1, r)
        else if (i > k - 1) quickSort(l, i - 1)
      }
    }

    quickSort(0, dis.length - 1)
    (0 until k).map(i => points(dis(i)._2)).toArray
  }
}
