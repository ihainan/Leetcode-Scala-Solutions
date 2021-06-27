package me.ihainan

object P773 {
  def swapNumber(num: Int, i: Int, j: Int): Int = {
    val powI = math.pow(10, i).toInt
    val powJ = math.pow(10, j).toInt
    val left = num / powI
    val right = num % powI
    val value = left % 10
    // println(num, i, j, value * powJ + right + (left / 10) * powI * 10)
    value * powJ + right + (left / 10) * powI * 10
  }

  def nextMove(num: Int): (Int, List[Int]) = {
    val index = 5 - f"$num%06d".indexOf('0')
    val list = index match {
      case 5 => List(4, 2)
      case 4 => List(5, 3, 1)
      case 3 => List(4, 0)
      case 2 => List(5, 1)
      case 1 => List(4, 2, 0)
      case 0 => List(3, 1)
    }
    (index, list)
  }

  def slidingPuzzle(board: Array[Array[Int]]): Int = {
    val start = board(0)(0) * 100000 + board(0)(1) * 10000 + board(0)(2) * 1000 +
      board(1)(0) * 100 + board(1)(1) * 10 + board(1)(2)
    val queue = collection.mutable.Queue(start)
    val visited = collection.mutable.Set(start)
    var step = 0
    while (queue.nonEmpty) {
      val nodes = queue.indices.map(_ => queue.dequeue)
      if (nodes.contains(123450)) return step
      nodes.foreach { current =>
        val (zero, moves) = nextMove(current)
        moves.foreach { move =>
          val next = swapNumber(current, move, zero)
          if (!visited(next)) {
            visited += next
            queue.enqueue(next)
          }
        }
      }
      step += 1
    }
    -1
  }
}