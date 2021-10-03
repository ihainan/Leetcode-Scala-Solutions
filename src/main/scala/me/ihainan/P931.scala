package me.ihainan

object P931 {
  def minFallingPathSum(matrix: Array[Array[Int]]): Int = {
    val (m, n) = (matrix.length, matrix.head.length)
    var dp = matrix.head
    (1 until m).foreach { i =>
      val t = Array.fill(n)(Int.MaxValue)
      (0 until n).foreach { j =>
        (-1 to 1).foreach { k =>
          if (j + k >= 0 && j + k < n) t(j) = t(j).min(dp(j + k) + matrix(i)(j))
        }
      }
      dp = t
    }
    dp.min
  }
}
