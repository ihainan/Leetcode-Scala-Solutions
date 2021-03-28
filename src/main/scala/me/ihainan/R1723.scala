package me.ihainan

object R1723 {
  def findSquare(matrix: Array[Array[Int]]): Array[Int] = {
    if (matrix.length == 0 || matrix.head.length == 0) Array.empty[Int]
    else {
      val (m, n) = (matrix.length, matrix.head.length)
      val horizon = Array.ofDim[Int](m, n)
      val vertical = Array.ofDim[Int](m, n)

      // build horizon
      (0 until m).foreach { i =>
        var current = 0
        (0 until n).foreach { j =>
          if (matrix(i)(j) == 0) {
            current += 1
            horizon(i)(j) = current
          } else current = 0
        }
      }

      // build vertical
      (0 until n).foreach { j =>
        var current = 0
        (0 until m).foreach { i =>
          if (matrix(i)(j) == 0) {
            current += 1
            vertical(i)(j) = current
          } else current = 0
        }
      }

      val ans = Array(-1, -1, 0)
      (0 until m).foreach { i =>
        (0 until n).foreach { j =>
          if (matrix(i)(j) == 0) {
            val size = (horizon(i)(j).min(vertical(i)(j)) to 1 by -1).collectFirst {
              case s if vertical(i)(j - s + 1).min(horizon(i - s + 1)(j)) >= s => s
            }.get

            if (size > ans(2)) {
              ans(2) = size
              ans(0) = i - size + 1
              ans(1) = j - size + 1
            }
          }
        }
      }

      if (ans(1) == -1) Array.empty[Int]
      else ans
    }
  }
}