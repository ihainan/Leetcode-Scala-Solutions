package me.ihainan

object O12 {
  def exist(board: Array[Array[Char]], word: String): Boolean = {
    board.indices.foreach { x =>
      board.head.indices.foreach { y =>
        if (dfs(board, 0, x, y, word)) return true
      }
    }
    false
  }

  val mx = Array(1, 0, -1, 0)
  val my = Array(0, 1, 0, -1)

  def dfs(board: Array[Array[Char]], i: Int, x: Int, y: Int, word: String): Boolean = {
    if (i == word.length) true
    else if (x < 0 || y < 0 || x >= board.length || y >= board.head.length) false
    else if (board(x)(y) != word(i)) false
    else {
      val tmp = board(x)(y)
      board(x)(y) = 0
      val ans = (0 until 4).exists { j => dfs(board, i + 1, x + mx(j), y + my(j), word) }
      board(x)(y) = tmp
      ans
    }
  }
}