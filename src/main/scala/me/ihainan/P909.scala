package me.ihainan

object P909 {
  def snakesAndLadders(board: Array[Array[Int]]): Int = {
    val n = board.length
    val nums = (n - 1 to 0 by -1).flatMap { i => if (i % 2 != n % 2) board(i) else board(i).reverse }
    val queue = collection.mutable.Queue(1)
    val visited = collection.mutable.Set(1)
    var step = 0
    while (queue.nonEmpty) {
      val nodes = queue.indices.map(_ => queue.dequeue)
      if (nodes.contains(n * n)) return step
      nodes.foreach { current =>
        (1 to 6).foreach { i =>
          val next = current + i
          if (next <= n * n && !visited(next)) {
            visited += next
            if (nums(next - 1) == -1) queue.enqueue(next)
            else if (!visited(nums(next - 1))) {
              visited += next
              queue.enqueue(nums(next - 1))
            }
          }
        }
      }
      step += 1
    }
    -1
  }
}