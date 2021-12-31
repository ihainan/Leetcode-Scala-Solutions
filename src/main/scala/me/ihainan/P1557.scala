package me.ihainan

object P1557 {
  def findSmallestSetOfVertices(n: Int, edges: List[List[Int]]): List[Int] = {
    val in = new Array[Int](n)
    edges.foreach { case List(f, t) => in(t) += 1 }
    in.indices.filter(i => in(i) == 0).toList
  }
}
