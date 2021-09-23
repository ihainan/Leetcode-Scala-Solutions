package me.ihainan

object P36Solution2 {
  def isValidSudoku(board: Array[Array[Char]]): Boolean = {
    val m1 = Array.fill(9, 10)(0)
    val m2 = Array.fill(9, 10)(0)
    val m3 = Array.fill(9, 10)(0)

    (0 until 9).foreach { i =>
      (0 until 9).foreach { j =>
        if (board(i)(j) != '.') {
          val num = board(i)(j) - '0'
          val k = (i / 3) * 3 + (j / 3)
          if (m1(i)(num) > 0 || m2(j)(num) > 0 || m3(k)(num) > 0) return false
          m1(i)(num) += 1
          m2(j)(num) += 1
          m3(k)(num) += 1
        }
      }
    }

    true
  }
}
