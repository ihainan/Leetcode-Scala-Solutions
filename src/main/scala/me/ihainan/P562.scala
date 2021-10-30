package me.ihainan

object P562 {
  def longestLine(mat: Array[Array[Int]]): Int = {
    val (m, n) = (mat.length, mat.head.length)
    var dp = Array.fill(n + 1, 4)(0)
    var ans = 0

    def fill(tp: Array[Int], a: Int, b: Int, c: Int, d: Int): Unit = {
      tp(0) = a
      tp(1) = b
      tp(2) = c
      tp(3) = d
    }

    mat.indices.foreach { i =>
      val tp = Array.fill(n + 1, 4)(0)
      mat(i).indices.foreach { j =>
        if (mat(i)(j) == 0) fill(tp(j), 0, 0, 0, 0)
        else if (i == 0 && j == 0) fill(tp(j), 1, 1, 1, 1)
        else if (i == 0) fill(tp(j), tp(j - 1)(0) + 1, 1, 1, 1)
        else if (j == 0) fill(tp(j), 1, dp(j)(1) + 1, 1, dp(j + 1)(3) + 1)
        else
          fill(
            tp(j),
            tp(j - 1)(0) + 1,
            dp(j)(1) + 1,
            dp(j - 1)(2) + 1,
            dp(j + 1)(3) + 1
          )
        ans = ans.max(tp(j)(0)).max(tp(j)(1)).max(tp(j)(2)).max(tp(j)(3))
      }
      dp = tp
    }

    ans
  }
}
