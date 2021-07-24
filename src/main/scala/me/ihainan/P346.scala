package me.ihainan

object P346 {
  class TicTacToe(_n: Int) {

    /** Initialize your data structure here. */
    val n = _n
    val board = Array.fill(n, n)(0)
    val rows = Array.fill(3, n)(0)
    val columns = Array.fill(3, n)(0)
    val diagonals = Array.fill(3, 2)(0)

    /** Player {player} makes a move at ({row}, {col}).
    @param row The row of the board.
    @param col The column of the board.
    @param player The player, can be either 1 or 2.
    @return The current winning condition, can be either:
              0: No one wins.
              1: Player 1 wins.
              2: Player 2 wins. */
    def move(row: Int, col: Int, player: Int): Int = {
      rows(player)(row) += 1
      columns(player)(col) += 1
      if (row == col) diagonals(player)(0) += 1
      if (row == n - col - 1) diagonals(player)(1) += 1
      if (rows(player)(row) == n || columns(player)(col) == n ||
        diagonals(player)(0) == n || diagonals(player)(1) == n) player
      else 0
    }

  }

  /**
    * Your TicTacToe object will be instantiated and called as such:
    * var obj = new TicTacToe(n)
    * var param_1 = obj.move(row,col,player)
    */
}