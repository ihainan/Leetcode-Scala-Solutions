package me.ihainan

object P5852Solution2 {
  def minimizeTheDifference(mat: Array[Array[Int]], target: Int): Int = {
    val (m, n) = (mat.length, mat.head.length)
    var ans = Int.MaxValue
    val sorted = mat.map(_.sorted)
    var dp = Array(true)
    var (maxSum, minSum) = (0, 0)
    (0 until m).foreach { i =>
      val tmp = new Array[Boolean](maxSum + sorted(i).last + 1)
      (0 until n).foreach { j =>
        val v = sorted(i)(j)
        (minSum + v to maxSum + v).foreach(k => tmp(k) = tmp(k) || dp(k - v))
      }
      minSum += sorted(i).head
      maxSum += sorted(i).last
      dp = tmp
    }

    (minSum to maxSum).foreach(j =>
      if (dp(j) && (j - target).abs < ans) ans = (j - target).abs
    )
    ans
  }
}
