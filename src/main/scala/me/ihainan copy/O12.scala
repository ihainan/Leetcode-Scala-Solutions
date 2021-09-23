package me.ihainan

object O12 {
  def exist(board: Array[Array[Char]], word: String): Boolean = {
    val (m, n) = (board.length, board.head.length)
    (0 until m).foreach { i =>
      (0 until n).foreach { j =>
        if (board(i)(j) == word.head) {
          if (dfs(board, 0, i, j, "", word)) return true
        }
      }
    }
    false
  }

  val mx = Array(0, 1, 0, -1)
  val my = Array(1, 0, -1, 0)

  def dfs(board: Array[Array[Char]], dep: Int, x: Int, y: Int, current: String, target: String): Boolean = {
    if (dep == target.length) current == target
    else if (x < 0 || x >= board.length || y < 0 || y >= board.head.length || board(x)(y) == 'X' || board(x)(y) != target(dep)) false
    else {
      board(x)(y) = 'X'
      val ans = (0 until 4).exists { i => dfs(board, dep + 1, x + mx(i), y + my(i), current + target(dep), target) }
      board(x)(y) = target(dep)
      ans
    }
  }
}