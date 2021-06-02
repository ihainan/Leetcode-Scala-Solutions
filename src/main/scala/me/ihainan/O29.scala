package me.ihainan

object O29 {
  val mx = Array(0, 1, 0, -1)
  val my = Array(1, 0, -1, 0)

  def spiralOrder(matrix: Array[Array[Int]]): Array[Int] = {
    if (matrix.length == 0 || matrix.head.length == 0) Array.empty[Int]
    else {
      val (m, n) = (matrix.length, matrix.head.length)
      var (x, y) = (0, -1)
      var d = 0
      val ans = new Array[Int](m * n)
      val visited = Array.fill(m, n)(false)
      (0 until m * n).foreach { i =>
        while (x + mx(d) < 0 || x + mx(d) >= m || y + my(d) < 0 || y + my(d) >= n || visited(x + mx(d))(y + my(d))) d = (d + 1) % 4
        x += mx(d)
        y += my(d)
        visited(x)(y) = true
        ans(i) = matrix(x)(y)
      }
      ans
    }
  }
}