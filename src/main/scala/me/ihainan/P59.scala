package me.ihainan

object P59 {
  def generateMatrix(n: Int): Array[Array[Int]] = {
    val ans = Array.fill(n)(new Array[Int](n))
    val mx = Array(0, 1, 0, -1)
    val my = Array(1, 0, -1, 0)
    var (x, y, direction) = (0, 0, 0)
    ans(0)(0) = 1
    (2 to n * n).foreach { i =>
      while ( {
        val nx = x + mx(direction)
        val ny = y + my(direction)
        !(nx >= 0 && ny >= 0 && nx < n && ny < n && ans(nx)(ny) == 0)
      }) direction = (direction + 1) % 4

      x = x + mx(direction)
      y = y + my(direction)
      ans(x)(y) = i
    }
    ans
  }
}