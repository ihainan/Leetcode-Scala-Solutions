package me.ihainan


object P1244Solution2 {
  class Leaderboard() {
    implicit val ordering = Ordering[Int].on { v: Int => -v }
    val idToScore = collection.mutable.Map.empty[Int, Int]
    val scoreToCount = collection.mutable.TreeMap.empty[Int, Int].withDefaultValue(0)

    def addScore(playerId: Int, score: Int) {
      if (idToScore.isDefinedAt(playerId)) {
        val oldScore = idToScore(playerId)
        scoreToCount(oldScore) = scoreToCount(oldScore) - 1
        scoreToCount(oldScore + score) = scoreToCount(oldScore + score) + 1
        idToScore(playerId) = oldScore + score
      } else {
        idToScore(playerId) = score
        scoreToCount(score) = scoreToCount(score) + 1
      }
    }

    def top(K: Int): Int = {
      var count = 0
      var sum = 0
      val iterator = scoreToCount.iterator
      while (iterator.hasNext) {
        val (k, v) = iterator.next
        if (count + v >= K) return sum + k * (K - count)
        else {
          count += v
          sum += k * v
        }
      }
      sum
    }

    def reset(playerId: Int) {
      val score = idToScore(playerId)
      idToScore -= playerId
      scoreToCount(score) = scoreToCount(score) - 1
      if (scoreToCount(score) == 0) scoreToCount -= score
    }

  }

  /**
   * Your Leaderboard object will be instantiated and called as such:
   * var obj = new Leaderboard()
   * obj.addScore(playerId,score)
   * var param_2 = obj.top(K)
   * obj.reset(playerId)
   */
}