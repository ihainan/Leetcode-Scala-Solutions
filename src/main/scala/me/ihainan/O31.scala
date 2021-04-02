package me.ihainan

object O31 {
  def validateStackSequences(pushed: Array[Int], popped: Array[Int]): Boolean = {
    val map = pushed.zipWithIndex.toMap
    var max = -1
    val queue = collection.mutable.PriorityQueue.empty[Int]
    popped.foreach { pop =>
      val index = map(pop)
      if (index > max) {
        (max + 1 until index).foreach { i => queue.enqueue(i) }
        max = index
      } else if (queue.dequeue != index) return false
    }
    true
  }
}