package me.ihainan

object P547 {
  def findCircleNum(isConnected: Array[Array[Int]]): Int = {
    val n = isConnected.length
    val parent = (0 until n).toArray

    def find(i: Int): Int = {
      if (parent(i) == i) i
      else {
        parent(i) = find(parent(i))
        parent(i)
      }
    }

    def union(i: Int, j: Int): Unit = {
      val pi = find(i)
      val pj = find(j)
      if (pi != pj)
        parent(pi) = pj
    }

    (0 until n).foreach { i =>
      (i + 1 until n).foreach { j =>
        if (isConnected(i)(j) == 1) union(i, j)
      }
    }

    parent.indices.count(i => parent(i) == i)
  }
}
