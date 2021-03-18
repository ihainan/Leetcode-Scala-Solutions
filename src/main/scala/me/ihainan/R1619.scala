package me.ihainan

object R1619 {
  def pondSizes(land: Array[Array[Int]]): Array[Int] = {
    val (m, n) = (land.length, land.head.length)
    val ans = collection.mutable.ArrayBuffer.empty[Int]
    (0 until m).foreach { i =>
      (0 until n).foreach { j =>
        if (land(i)(j) == 0) ans += dfs(land, i, j, m, n)
      }
    }
    ans.toArray.sorted
  }

  val mx = Array(-1, 0, 1, 0, -1, -1, 1, 1)
  val my = Array(0, 1, 0, -1, -1, 1, 1, -1)

  def dfs(land: Array[Array[Int]], x: Int, y: Int, m: Int, n: Int): Int = {
    if (x < 0 || y < 0 || x >= m || y >= n || land(x)(y) != 0) 0
    else {
      land(x)(y) = 1
      1 + (0 until 8).map { i => dfs(land, x + mx(i), y + my(i), m, n) }.sum
    }
  }
}