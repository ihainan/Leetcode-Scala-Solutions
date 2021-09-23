package me.ihainan

object P1583 {
  def unhappyFriends(n: Int, preferences: Array[Array[Int]], pairs: Array[Array[Int]]): Int = {
    val map = preferences.map(p => p.zip(n - 1 to 0 by -1).toMap)
    val set = collection.mutable.Set.empty[Int]

    def unhappy(a: Int, b: Int, c: Int, d: Int): Boolean = {
      (map(a)(b) < map(a)(c) && map(c)(a) > map(c)(d)) ||
        (map(a)(b) < map(a)(d) && map(d)(a) > map(d)(c))
    }

    pairs.foreach { p1 =>
      pairs.foreach { p2 =>
        val (a, b, c, d) = (p1(0), p1(1), p2(0), p2(1))
        if (Set(a, b, c, d).size == 4) {
          if (!set(a) && unhappy(a, b, c, d)) set += a
          if (!set(b) && unhappy(b, a, c, d)) set += b
          if (!set(c) && unhappy(c, d, a, b)) set += c
          if (!set(d) && unhappy(d, c, a, b)) set += d
        }
      }
    }

    set.size
  }
}