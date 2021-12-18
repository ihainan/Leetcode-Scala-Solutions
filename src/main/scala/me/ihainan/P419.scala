package me.ihainan

object P419 {
  def countBattleships(board: Array[Array[Char]]): Int = {
    var ans = 0
    val (m, n) = (board.length, board.head.length)
    (0 until m).foreach { i =>
      (0 until n).foreach { j =>
        if (board(i)(j) == 'X') {
          if ((i == m - 1 || board(i + 1)(j) == '.') && (j == n - 1 || board(i)(j + 1) == '.')) {
            if (i == 0 || board(i - 1)(j) == 'X') ans += 1
            else ans += 1
          }
        }
      }
    }
    ans
  }
}