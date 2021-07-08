package me.ihainan

object P277 {

  class Relation {
    def knows(i: Int, j: Int) = true
  }

  class Solution extends Relation {
    def findCelebrity(n: Int): Int = {
      val celebrities = (0 until n).flatMap { i =>
        if ((0 until n).exists(j => i != j && (knows(i, j) || !knows(j, i)))) None
        else Some(i)
      }
      if (celebrities.size == 1) celebrities.head else -1
    }
  }

}