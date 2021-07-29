package me.ihainan

object P361Solution2 {
  def maxKilledEnemies(grid: Array[Array[Char]]): Int = {
    val (m, n) = (grid.length, grid.head.length)
    val ans = Array.fill(m, n)(0)
    var prev = 0

    def updatePrev(i: Int, j: Int, c: Char): Unit = {
      c match {
        case 'E' => prev += 1
        case 'W' => prev = 0
        case '0' => ans(i)(j) += prev
      }
    }

    (0 until m).foreach { i => prev = 0; (0 until n).foreach { j => updatePrev(i, j, grid(i)(j)) } }
    (0 until m).foreach { i => prev = 0; (n - 1 to 0 by -1).foreach { j => updatePrev(i, j, grid(i)(j)) } }
    (0 until n).foreach { j => prev = 0; (0 until m).foreach { i => updatePrev(i, j, grid(i)(j)) } }
    (0 until n).foreach { j => prev = 0; (m - 1 to 0 by -1).foreach { i => updatePrev(i, j, grid(i)(j)) } }

    ans.map(_.max).max
  }
}