package me.ihainan

object R1604 {
  def isValid(x: Int, y: Int, m: Int, n: Int): Boolean = x >= 0 && x < m && y >= 0 && y < n

  val mx = Array(0, 1, 1, 1)
  val my = Array(1, 1, 0, -1)

  def find(x: Int, y: Int, target: Char, board: Array[String]): Boolean = {
    val (m, n) = (board.length, board.head.length)
    val ex = Array(x, x + n - 1, x + n - 1, x + n - 1)
    val ey = Array(y + n - 1, y + n - 1, y, y - n + 1)

    (0 until 4).exists { i =>
      if (!isValid(ex(i), ey(i), m, n)) false
      else !(0 until n).exists { j => board(x + j * mx(i))(y + j * my(i)) != target }
    }
  }

  def tictactoe(board: Array[String]): String = {
    var flag = false
    val (m, n) = (board.length, board.head.length)
    (0 until m).foreach { i =>
      (0 until n).foreach { j =>
        if (board(i)(j) == ' ') flag = true
        else if (find(i, j, 'O', board)) return "O"
        else if (find(i, j, 'X', board)) return "X"
      }
    }

    if (flag) "Pending"
    else "Draw"
  }
}