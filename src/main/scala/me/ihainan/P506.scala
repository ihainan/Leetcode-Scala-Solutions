package me.ihainan

object P506 {
  def findRelativeRanks(score: Array[Int]): Array[String] = {
    val sorted = score.zipWithIndex.sortBy { case (score, index) => -score }
    val ranks = sorted.indices.map { rank => sorted(rank)._2 -> rank }.toMap
    score.indices.map { i =>
      val rank = ranks(i)
      if (rank == 0) "Gold Medal"
      else if (rank == 1) "Silver Medal"
      else if (rank == 2) "Bronze Medal"
      else (rank + 1).toString
    }.toArray
  }
}
