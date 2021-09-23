package me.ihainan

object R1708 {
  def bestSeqAtIndex(height: Array[Int], weight: Array[Int]): Int = {
    val sorted = height.zip(weight).sortWith { case (v1, v2) =>
      if (v1._1 == v2._1) v1._2 <= v2._2
      else v1._1 <= v2._1
    }
    val dp = Array.fill(height.length)(1)
    var max = 1

    (1 until height.length).foreach { i =>
      var j = 0
      while (j < i && sorted(j)._1 < sorted(i)._1) {
        if (sorted(j)._2 < sorted(i)._2 && dp(j) + 1 > dp(i)) {
          dp(i) = dp(j) + 1
        }
        j += 1
      }
      max = max.max(dp(i))
    }

    max
  }
}