package me.ihainan

object P1947Solution2 {
  def maxCompatibilitySum(students: Array[Array[Int]], mentors: Array[Array[Int]]): Int = {
    val map = collection.mutable.Map.empty[(Int, Int), Int]
    students.indices.foreach { i =>
      mentors.indices.foreach { j =>
        map((i, j)) = students(i).zip(mentors(j)).count { case (v1, v2) => v1 == v2 }
      }
    }

    val m = students.length
    val maxNum = 1 << m
    val dp = Array.fill(maxNum)(0)
    (1 until maxNum).foreach { mask =>
      val bitCount = Integer.bitCount(mask)
      (0 until m).foreach { i =>
        if (((1 << i) & mask) != 0) {
          dp(mask) = dp(mask).max(dp(mask ^ (1 << i)) + map((bitCount - 1, i)))
        }
      }
    }

    dp(maxNum - 1)
  }
}