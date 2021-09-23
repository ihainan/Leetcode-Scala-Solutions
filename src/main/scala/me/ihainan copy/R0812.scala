package me.ihainan

object R0812 {
  def solveNQueens(n: Int): List[List[String]] = {
    solve(0, n, List.empty[Int])
  }

  def solve(i: Int, n: Int, pos: List[Int]): List[List[String]] = {
    if (i == n) List(pos.map { p => (0 until n).map { j => if (j == p) 'Q' else '.' }.mkString })
    else {
      (0 until n).map { j =>
        if (!pos.indices.exists { k => pos(k) == j || (k - i).abs == (j - pos(k)).abs }) solve(i + 1, n, pos :+ j)
        else Nil
      }.reduce(_ ::: _)
    }
  }
}