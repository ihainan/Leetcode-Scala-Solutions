package me.ihainan

object P1136 {
  def minimumSemesters(n: Int, relations: Array[Array[Int]]): Int = {
    var ans = 0
    val map = collection.mutable.Map.empty[Int, List[Int]].withDefaultValue(Nil)
    val in = new Array[Int](n)
    val queue = collection.mutable.Queue.empty[Int]

    relations.foreach { r =>
      map(r(0) - 1) = map(r(0) - 1) :+ (r(1) - 1)
      in(r(1) - 1) += 1
    }

    (0 until n).foreach { i => if (in(i) == 0) queue.enqueue(i) }
    while (queue.nonEmpty) {
      val nodes = queue.indices.map { _ => queue.dequeue }
      ans += 1
      nodes.foreach { node =>
        map(node).foreach { next =>
          in(next) -= 1
          if (in(next) == 0) queue.enqueue(next)
        }
        map -= node
      }
    }

    if (in.count(_ > 0) > 0) -1
    else ans
  }
}