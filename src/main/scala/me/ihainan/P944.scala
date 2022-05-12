package me.ihainan

object P944 {
  def minDeletionSize(strs: Array[String]): Int = {
    strs.head.indices.count { i =>
      (1 until strs.length).exists { j =>
        strs(j)(i) < strs(j - 1)(i)
      }
    }
  }
}
