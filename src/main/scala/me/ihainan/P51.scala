package me.ihainan

object P51 {
  def solveNQueens(n: Int): List[List[String]] = {
    solve(0, n, List.empty[Int])
  }

  def solve(i: Int, n: Int, path: List[Int]): List[List[String]] = {
    if (i == n) {
      List((0 until n).map { j => (0 until n).map { k => if (k == path(j)) 'Q' else '.' }.mkString }.toList)
    } else {
      (0 until n).map { j =>
        if (path.indices.exists { k => path(k) == j || (i - k).abs == (j - path(k)).abs }) List.empty[List[String]]
        else solve(i + 1, n, path :+ j)
      }.reduce(_ ::: _)
    }
  }
}