package me.ihainan

object P54 {
  val mx = Array(0, 1, 0, -1)
  val my = Array(1, 0, -1, 0)

  def spiralOrder(matrix: Array[Array[Int]]): List[Int] = {
    val (m, n) = (matrix.length, matrix.head.length)
    var sum = m * n
    var (x, y) = (0, -1)
    var move = 0
    val ans = collection.mutable.ListBuffer.empty[Int]

    while (sum > 0) {
      val nextX = x + mx(move)
      val nextY = y + my(move)
      if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n || matrix(nextX)(nextY) == -101) move = (move + 1) % 4
      else {
        x = nextX
        y = nextY
        ans += matrix(x)(y)
        matrix(x)(y) = -101
        sum -= 1
      }
    }

    ans.toList
  }
}