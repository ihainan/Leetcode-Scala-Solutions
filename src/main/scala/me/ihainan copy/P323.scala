package me.ihainan

object P323 {
  def countComponents(n: Int, edges: Array[Array[Int]]): Int = {
    val parent = (0 until n).map(x => x).toArray

    def find(x: Int): Int = {
      if (parent(x) != x) parent(x) = find(parent(x))
      parent(x)
    }

    def union(x: Int, y: Int): Unit = {
      val px = find(x)
      val py = find(y)
      if (px != py) parent(px) = py
    }

    edges.foreach { edge => union(edge(0), edge(1)) }
    (0 until n).count { x => parent(x) == x }
  }
}