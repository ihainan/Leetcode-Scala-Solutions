package me.ihainan

object P773Solution2 {
  val moves = Array(List(1, 3), List(0, 2, 4), List(1, 5),
    List(0, 4), List(1, 3, 5), List(2, 4))

  def slidingPuzzle(board: Array[Array[Int]]): Int = {
    val start = board.flatten.mkString
    val queue = collection.mutable.Queue(start)
    val visited = collection.mutable.Set(start)
    var step = 0
    while (queue.nonEmpty) {
      val list = queue.indices.map(_ => queue.dequeue)
      if (list.contains("123450")) return step
      list.foreach { current =>
        val zeroIndex = current.indexOf('0')
        moves(zeroIndex).foreach { toSwap =>
          val chars = current.toCharArray
          chars(zeroIndex) = chars(toSwap)
          chars(toSwap) = '0'
          val next = new String(chars)
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