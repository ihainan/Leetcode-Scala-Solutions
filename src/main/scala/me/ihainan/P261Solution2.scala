package me.ihainan

object P261Solution2 {
  def validTree(n: Int, edges: Array[Array[Int]]): Boolean = {
    val parent = (0 until n).map(i => i).toArray

    def find(x: Int): Int = {
      if (parent(x) != x) parent(x) = find(parent(x))
      parent(x)
    }

    edges.foreach { edge =>
      val (p1, p2) = (find(edge(0)), find(edge(1)))
      if (p1 == p2) return false
      else parent(p2) = p1
    }

    (0 until n).foreach(i => find(i))
    parent.distinct.length == 1
  }
}