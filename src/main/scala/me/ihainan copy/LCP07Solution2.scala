package me.ihainan

object LCP07Solution2 {
  def numWays(n: Int, relation: Array[Array[Int]], k: Int): Int = {
    var ans = 0
    val map = collection.mutable.Map.empty[Int, List[Int]].withDefaultValue(Nil)
    relation.foreach { arr => map(arr(0)) = map(arr(0)) :+ arr(1) }

    val queue = collection.mutable.Queue(0)
    var step = 0
    while (queue.nonEmpty) {
      val nodes = queue.indices.map { _ => queue.dequeue }
      if (step == k) ans += nodes.count(_ == n - 1)
      else nodes.foreach { current => map(current).foreach { next => queue.enqueue(next) } }
      step += 1
    }

    ans
  }
}