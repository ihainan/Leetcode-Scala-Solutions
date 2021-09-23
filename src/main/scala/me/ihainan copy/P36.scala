package me.ihainan

object P36 {
  def isValidSudoku(board: Array[Array[Char]]): Boolean = {
    val (m, n) = (board.length, board.head.length)

    (0 until m).foreach { i =>
      val nums = (0 until n).flatMap { j =>
        if (board(i)(j) == '.') None
        else Some(board(i)(j) - '0')
      }.toArray
      if (nums.toSet.size != nums.length) return false
    }

    (0 until n).foreach { j =>
      val nums = (0 until m).flatMap { i =>
        if (board(i)(j) == '.') None
        else Some(board(i)(j) - '0')
      }.toArray
      if (nums.toSet.size != nums.length) return false
    }

    (0 until m by 3).foreach { i =>
      (0 until n by 3).foreach { j =>
        val nums =
          (i to i + 2).flatMap { k =>
            (j to j + 2).flatMap { l =>
              if (board(k)(l) == '.') None
              else Some(board(k)(l) - '0')
            }
          }.toArray
        if (nums.toSet.size != nums.length) return false
      }
    }

    true
  }
}
