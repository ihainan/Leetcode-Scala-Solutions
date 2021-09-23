package me.ihainan

object P1337Solution2 {
  @annotation.tailrec
  def find(nums: Array[Int], l: Int, r: Int): Int = {
    if (l > r) -1
    else if (nums(r) == 1) r
    else {
      val m = (l + r) >>> 1
      if (nums(m) == 1) find(nums, m, r - 1) else find(nums, l, m - 1)
    }
  } 

  def swap(array: Array[(Int, Int)], i: Int, j: Int): Unit = {
    val tmp = array(i)
    array(i) = array(j)
    array(j) = tmp
  }

  def compare(v1: (Int, Int), v2: (Int, Int)): Int = {
    if (v1._2 == v2._2 && v1._1 == v2._1) 0
    else if (v1._2 < v2._2 || (v1._2 == v2._2 && v1._1 < v2._1)) -1
    else 1
  }

  @annotation.tailrec
  def quickFind(array: Array[(Int, Int)], l: Int, r: Int, k: Int): Unit = {
    if (l < r) {
      val tmp = array(l)
      var (i, j) = (l, r)
      while (i < j) {
        while (i < j && compare(array(j), tmp) > 0) j -= 1
        while (i < j && compare(array(i), tmp) <= 0) i += 1
        swap(array, i, j)
      }
      swap(array, l, i)
      if (i > k) quickFind(array, l, i - 1, k)
      else if (i < k) quickFind(array, i + 1, r, k)
    }
  }

  def kWeakestRows(mat: Array[Array[Int]], k: Int): Array[Int] = {
    val power = mat.indices.map { i => (i, find(mat(i), 0, mat(i).length - 1)) }.toArray
    quickFind(power, 0, power.length - 1, k - 1)
    println(power.mkString(", "))
    power.slice(0, k).map(_._1)
  }
}