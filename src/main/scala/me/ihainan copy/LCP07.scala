package me.ihainan

object LCP07 {
  def numWays(n: Int, relation: Array[Array[Int]], k: Int): Int = {
    var ans = 0
    val map = collection.mutable.Map.empty[Int, List[Int]].withDefaultValue(Nil)
    relation.foreach { arr => map(arr(0)) = map(arr(0)) :+ arr(1) }

    def visit(depth: Int, current: Int): Unit = {
      if (depth == k) {
        if (current == n - 1) ans += 1
      } else {
        map(current).foreach { next => visit(depth + 1, next) }
      }
    }

    visit(0, 0)
    ans
  }
}