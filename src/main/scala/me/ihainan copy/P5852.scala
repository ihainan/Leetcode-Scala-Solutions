package me.ihainan

object P5852 {
  def minimizeTheDifference(mat: Array[Array[Int]], target: Int): Int = {
    val (m, n) = (mat.length, mat.head.length)
    val sorted = mat.map(_.sorted)
    val max = sorted.map(_.last).sum
    val dp = Array.fill(m, max + 1)(false)
    var currentMax = sorted(0).last
    var currentMin = sorted(0).head
    (0 until n).foreach(j => dp(0)(sorted(0)(j)) = true)
    (1 until m).foreach { i =>
      currentMax += sorted(i).last
      currentMin += sorted(i).head
      (0 until n).foreach { j =>
        val v = sorted(i)(j)
        (currentMax to currentMin.max(v) by -1).foreach(k =>
          dp(i)(k) = dp(i)(k) || dp(i - 1)(k - v)
        )
      }
    }

    var ans = -1000000
    (currentMin to max).foreach(j =>
      if (dp(m - 1)(j) && (j - target).abs < (ans - target).abs) ans = j
    )
    (ans - target).abs
  }
}
