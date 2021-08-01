package me.ihainan

object P361 {
  val mx = Array(0, 1, 0, -1)
  val my = Array(1, 0, -1, 0)

  def maxKilledEnemies(grid: Array[Array[Char]]): Int = {
    var ans = 0
    val (m, n) = (grid.length, grid.head.length)
    (0 until m).foreach { i =>
      (0 until n).foreach { j =>
        if (grid(i)(j) == '0') {
          var count = 0
          (0 until 4).foreach { k =>
            var (nx, ny) = (i, j)
            while (nx >= 0 && nx < m && ny >= 0 && ny < n && grid(nx)(ny) != 'W') {
              if (grid(nx)(ny) == 'E') count += 1
              nx += mx(k)
              ny += my(k)
            }
          }
          ans = ans.max(count)
        }
      }
    }
    ans
  }
}