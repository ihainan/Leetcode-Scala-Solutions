package me.ihainan

object R1724 {
  def getMaxMatrix(matrix: Array[Array[Int]]): Array[Int] = {
    var max = Int.MinValue
    var ans = Array(-1, -1, -1, -1)
    val (m, n) = (matrix.length, matrix.head.length)
    val tmp = Array.ofDim[Int](m, n)
    (0 until m).foreach { i =>
      (0 until n).foreach { j =>
        if (i == 0 && j == 0) tmp(i)(j) = matrix(0)(0)
        else if (i == 0) tmp(i)(j) = tmp(i)(j - 1) + matrix(i)(j)
        else if (j == 0) tmp(i)(j) = tmp(i - 1)(j) + matrix(i)(j)
        else tmp(i)(j) = tmp(i - 1)(j) + tmp(i)(j - 1) - tmp(i - 1)(j - 1) + matrix(i)(j)
      }
    }

    (0 until m).foreach { i =>
      (0 until n).foreach { j =>
        (i until m).foreach { k =>
          (j until n).foreach { l =>
            val sum =
              if (i == 0 && j == 0) tmp(k)(l)
              else if (i == 0) tmp(k)(l) - tmp(k)(j - 1)
              else if (j == 0) tmp(k)(l) - tmp(i - 1)(l)
              else tmp(k)(l) - tmp(k)(j - 1) - tmp(i - 1)(l) + tmp(i - 1)(j - 1)
            if (sum > max) {
              max = sum
              ans = Array(i, j, k, l)
            }
          }
        }
      }
    }
    ans
  }
}