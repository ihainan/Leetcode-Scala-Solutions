package me.ihainan

// O(N * N)
object R0813 {
  def pileBox(box: Array[Array[Int]]): Int = {
    val sorted = box.sortBy(b => -b(0))
    val dp = new Array[Int](sorted.length)
    var max = 0
    sorted.indices.foreach { i =>
      dp(i) = sorted(i)(2)
      (0 until i).foreach { j =>
        if (sorted(i)(0) < sorted(j)(0) && sorted(i)(1) < sorted(j)(1) && sorted(i)(2) < sorted(j)(2)) {
          dp(i) = dp(i).max(dp(j) + sorted(i)(2))
        }
      }
      max = max.max(dp(i))
    }
    max
  }
}