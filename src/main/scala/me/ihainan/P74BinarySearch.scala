package me.ihainan

object P74BinarySearch {
  def searchMatrix(matrix: Array[Array[Int]], target: Int): Boolean = {
    find(0, matrix.length * matrix.head.length - 1, matrix, target)
  }

  @scala.annotation.tailrec
  def find(l: Int, r: Int, matrix: Array[Array[Int]], target: Int): Boolean = {
    if (l > r) false
    else {
      val mid = (l + r) >>> 1
      val x = mid / matrix.head.length
      val y = mid % matrix.head.length
      if (matrix(x)(y) == target) true
      else if (matrix(x)(y) > target) find(l, mid - 1, matrix, target)
      else find(mid + 1, r, matrix, target)
    }
  }
}