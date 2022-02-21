package me.ihainan

object P1791 {
  def findCenter(edges: Array[Array[Int]]): Int = {
    val out = new Array[Int](edges.length + 1)
    edges.foreach { case Array(f, t) => out(f - 1) += 1; out(t - 1) += 1 }
    // println(out.mkString(", "))
    out.indices.filter(i => out(i) == edges.length).head + 1
  }
}