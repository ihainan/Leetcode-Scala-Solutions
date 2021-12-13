package me.ihainan

object P794 {
  def validTicTacToe(board: Array[String]): Boolean = {
    var countX = board.map(_.count(_ == 'X')).sum
    var countO = board.map(_.count(_ == 'O')).sum
    if (countX != countO && countX != countO + 1) return false
    var winX = 0
    var winO = 0

    (0 until 3).foreach { i =>
      if ((0 until 3).forall(j => board(i)(j) == 'X')) winX += 1
      else if ((0 until 3).forall(j => board(i)(j) == 'O')) winO += 1
      if ((0 until 3).forall(j => board(j)(i) == 'X')) winX += 1
      else if ((0 until 3).forall(j => board(j)(i) == 'O')) winO += 1
    }

    if ((0 until 3).forall(i => board(i)(i) == 'X')) winX += 1
    else if ((0 until 3).forall(i => board(i)(i) == 'O')) winO += 1
    if ((0 until 3).forall(i => board(i)(2 - i) == 'X')) winX += 1
    else if ((0 until 3).forall(i => board(i)(2 - i) == 'O')) winO += 1

    if (winX > 0 && winO > 0) false
    else if (winX == 1 && countX != countO + 1) false
    else if (winO == 1 && countX != countO) false
    else true
  }
}
