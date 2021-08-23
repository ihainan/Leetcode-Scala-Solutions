package me.ihainan

object P444 {

  import collection.mutable

  def sequenceReconstruction(org: Array[Int], seqs: List[List[Int]]): Boolean = {
    val n = org.length
    val in = new Array[Int](n)
    val out = Array.fill(n)(List.empty[Int])

    val flatten = seqs.flatten.toSet
    if (flatten.size != n || flatten.exists(v => v <= 0 || v > n)) return false

    seqs.foreach { seq =>
      (1 until seq.length).foreach { i =>
        val (from, to) = (seq(i - 1) - 1, seq(i) - 1)
        if (from < 0 || from >= n || to < 0 || to >= n) return false
        in(to) += 1
        out(from) = out(from) :+ to
      }
    }

    val queue = mutable.Queue.empty[Int]
    in.indices.foreach(i => if (in(i) == 0) queue.enqueue(i))

    var cur = 0
    while (queue.nonEmpty) {
      if (queue.size != 1) return false
      val node = queue.dequeue
      if (node != org(cur) - 1) return false
      cur += 1
      out(node).foreach { next =>
        in(next) -= 1
        if (in(next) == 0) queue.enqueue(next)
      }
    }

    cur == org.length
  }
}