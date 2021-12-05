package me.ihainan

object P986 {
  def intervalIntersection(
      firstList: Array[Array[Int]],
      secondList: Array[Array[Int]]
  ): Array[Array[Int]] = {
    var (i, j) = (0, 0)
    val ans = collection.mutable.ArrayBuffer.empty[Array[Int]]
    while (i < firstList.length && j < secondList.length) {
      val maxLeft = firstList(i)(0) max secondList(j)(0)
      val minRight = firstList(i)(1) min secondList(j)(1)
      if (maxLeft <= minRight) ans += Array(maxLeft, minRight)
      if (firstList(i)(1) < secondList(j)(1)) i += 1 else j += 1
    }
    ans.toArray
  }
}
