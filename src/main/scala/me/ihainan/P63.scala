package me.ihainan

object P63 {
  def uniquePathsWithObstacles(obstacleGrid: Array[Array[Int]]): Int = {
    val (m, n) = (obstacleGrid.length, obstacleGrid.head.length)
    var dp = new Array[Int](n)
    (0 until m).foreach { i =>
      val tp = new Array[Int](n)
      (0 until n).foreach { j =>
        if (obstacleGrid(i)(j) == 1) tp(j) = 0
        else if (i == 0 && j == 0) tp(j) = 1
        else if (j == 0) tp(j) = dp(j)
        else tp(j) = dp(j) + tp(j - 1)
      }
      dp = tp
    }
    dp.last
  }
}
