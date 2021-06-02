package me.ihainan

object P1744 {
  def canEat(candiesCount: Array[Int], queries: Array[Array[Int]]): Array[Boolean] = {
    var tmp = 0L
    val sums = candiesCount.map { count => tmp += count; tmp }

    def range(i: Int): (Long, Long) = {
      val prevSum = if (i == 0) 0 else sums(i - 1)
      val currentSum = sums(i)
      (prevSum + 1, currentSum)
    }

    queries.map { query =>
      val (t, d, c) = (query(0), query(1), query(2))
      val (rl, rr) = range(t)
      val (min, max) = (d.toLong + 1, (d.toLong + 1) * c)
      !(rl > max || rr < min)
    }
  }
}