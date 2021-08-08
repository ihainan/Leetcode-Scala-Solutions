package me.ihainan

object P1337 {
  @annotation.tailrec
  def find(nums: Array[Int], l: Int, r: Int): Int = {
    if (l > r) -1
    else if (nums(r) == 1) r
    else {
      val m = (l + r) >>> 1
      if (nums(m) == 1) find(nums, m, r - 1)
      else find(nums, l, m - 1)
    }
  }

  def kWeakestRows(mat: Array[Array[Int]], k: Int): Array[Int] = {
    val (m, n) = (mat.length, mat.head.length)
    val indices = (0 until m).map { i => (i, find(mat(i), 0, n - 1)) }.toArray

    def swap(i: Int, j: Int): Unit = {
      val tmp = indices(i)
      indices(i) = indices(j)
      indices(j) = tmp
    }

    def quickFind(l: Int, r: Int): Unit = {
      if (l < r) {
        val tmp = indices(l)._2
        var (i, j) = (l, r)
        while (i < j) {
          while (i < j && indices(j)._2 > tmp) j -= 1
          while (i < j && indices(i)._2 <= tmp) i += 1
          swap(i, j)
        }
        swap(l, i)
        if (i > k - 1) quickFind(l, i - 1)
        else quickFind(i + 1, r)
      }
    }

    quickFind(0, n - 1)
    indices.slice(0, k).map(_._1)
  }
}