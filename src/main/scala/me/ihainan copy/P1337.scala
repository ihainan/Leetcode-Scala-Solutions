package me.ihainan

object P1337 {
  @annotation.tailrec
  def find(nums: Array[Int], l: Int, r: Int): Int = {
    if (l > r) -1
    else if (nums(r) == 1) r
    else {
      val m = (l + r) >>> 1
      if (nums(m) == 1) find(nums, m, r - 1) else find(nums, l, m - 1)
    }
  } 

  def kWeakestRows(mat: Array[Array[Int]], k: Int): Array[Int] = {
    mat.indices.map { i => (i, find(mat(i), 0, mat(i).length - 1)) }
      .sortWith { case (v1, v2) =>
        if (v1._2 == v2._2) v1._1 < v2._1
        else v1._2 < v2._2
      }.map(_._1).toArray.slice(0, k)
  }
}