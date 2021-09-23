package me.ihainan

import scala.collection.mutable.{Map, Set}

object R0401_DFS {
  def findWhetherExistsPath(n: Int, graph: Array[Array[Int]], start: Int, target: Int): Boolean = {
    val map = Map.empty[Int, Set[Int]]
    graph.foreach { edge => if (map.isDefinedAt(edge(0))) map(edge(0)) += edge(1) else map(edge(0)) = Set(edge(1)) }
    visit(map, start, target, Set.empty[Int])
  }

  def visit(map: Map[Int, Set[Int]], i: Int, t: Int, visited: Set[Int]): Boolean = {
    if (i == t) true
    else if (visited(i)) false
    else {
      visited(i) = true
      val ans = map.isDefinedAt(i) && map(i).exists { j => visit(map, j, t, visited) }
      visited(i) = false
      ans
    }
  }
}
