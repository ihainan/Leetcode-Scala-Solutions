package me.ihainan

object P311 {
  import collection.mutable

  def multiply(
      mat1: Array[Array[Int]],
      mat2: Array[Array[Int]]
  ): Array[Array[Int]] = {
    val (m1, n1, m2, n2) =
      (mat1.length, mat1.head.length, mat2.length, mat2.head.length)
    val ans = Array.fill(m1, n2)(0)
    val map1 = mutable.Map.empty[Int, List[(Int, Int)]].withDefaultValue(Nil)
    val map2 = mutable.Map.empty[Int, List[(Int, Int)]].withDefaultValue(Nil)
    (0 until m1.max(m2)).foreach { i =>
      (0 until n1.max(n2)).foreach { j =>
        if (i < m1 && j < n1) map1(i) = map1(i) :+ (j, mat1(i)(j))
        if (i < m2 && j < n2) map2(i) = map2(i) :+ (j, mat2(i)(j))
      }
    }
    map1.foreach { case (i, list) =>
      list.foreach { case (j, v1) =>
        map2(j).foreach { case (k, v2) =>
          ans(i)(k) += v1 * v2
        }
      }
    }
    ans
  }
}
