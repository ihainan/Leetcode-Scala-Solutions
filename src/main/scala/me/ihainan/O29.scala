package me.ihainan

object O29 {
  val mx: Array[Int] = Array(0, 1, 0, -1)
  val my: Array[Int] = Array(1, 0, -1, 0)

  def spiralOrder(matrix: Array[Array[Int]]): Array[Int] = {
    if (matrix.length == 0 || matrix.head.length == 0) Array.empty[Int]
    else {
      val (m, n) = (matrix.length, matrix.head.length)
      var (x, y, direction) = (0, 0, 0)
      val ans = Array.ofDim[Int](m * n)
      val visited = Array.ofDim[Int](m, n)

      (0 until m * n).foreach { i =>
        visited(x)(y) = 1
        ans(i) = matrix(x)(y)
        val (nx, ny) = (x + mx(direction), y + my(direction))
        if (nx < 0 || ny < 0 || nx >= m || ny >= n || visited(nx)(ny) == 1) {
          direction = (direction + 1) % 4
        }
        x += mx(direction)
        y += my(direction)
      }

      ans
    }
  }
}