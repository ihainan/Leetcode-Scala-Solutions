package me.ihainan

object P576 {
  val mx = Array(1, 0, -1, 0)
  val my = Array(0, 1, 0, -1)

  val MOD = (1e9 + 7).toInt
  def mod(v: Int) = ((v.toLong + MOD) % MOD).toInt

  def findPaths(
      m: Int,
      n: Int,
      maxMove: Int,
      startRow: Int,
      startColumn: Int
  ): Int = {
    var dp = Array.fill(m, n)(0)
    var ans = 0
    dp(startRow)(startColumn) = 1

    (0 until maxMove).foreach { move =>
      val newDp = Array.fill(m, n)(0)
      (0 until m).foreach { i =>
        (0 until n).foreach { j =>
          var count = dp(i)(j)
          if (count > 0) {
            (0 until 4).foreach { k =>
              val (nx, ny) = (i + mx(k), j + my(k))
              if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                newDp(nx)(ny) = mod(newDp(nx)(ny) + count)
              } else ans = mod(ans + count)
            }
          }
        }
      }
      dp = newDp
    }

    ans
  }
}
