package me.ihainan

object P277Solution2 {
  class Relation {
    def knows(i: Int, j: Int) = true
  }

  class Solution extends Relation {
    def findCelebrity(n: Int): Int = {
      var candicate = 0
      (1 until n).foreach { i => if (knows(candicate, i)) candicate = i }
      if (
        (0 until n).exists { i =>
          i != candicate && knows(candicate, i) || !knows(i, candicate)
        }
      ) -1
      else candicate
    }
  }
}
