package me.ihainan

object P576 {
  val mx = Array(0, 1, 0, -1)
  val my = Array(1, 0, -1, 0)

  def findPaths(
      m: Int,
      n: Int,
      maxMove: Int,
      startRow: Int,
      startColumn: Int
  ): Int = {
    var dp = Array.fill(m, n)(0)
    var ans = 0

    (1 to maxMove).foreach { k =>
      val dpNew = Array.fill(m, n)(0)
      (0 until m).foreach { i =>
        (0 until n).foreach { j =>
          if (k == 1) {
            if (i == 0) dpNew(i)(j) += 1
            if (j == 0) dpNew(i)(j) += 1
            if (i == m - 1) dpNew(i)(j) += 1
            if (j == n - 1) dpNew(i)(j) += 1
          } else {
            (0 until 4).foreach { l =>
              val (px, py) = (i + mx(l), j + my(l))
              if (px >= 0 && px < m && py >= 0 && py < n) {
                dpNew(i)(j) = (dpNew(i)(j) + dp(px)(py)) % 1000000007
              }
            }
          }
          if (i == startRow && j == startColumn)
            ans = (ans + dpNew(i)(j)) % 1000000007
        }
      }
      dp = dpNew
    }

    ans
  }
}
