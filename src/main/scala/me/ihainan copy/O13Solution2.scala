package me.ihainan

object O13Solution2 {
  def movingCount(m: Int, n: Int, k: Int): Int = {
    def numSum(num: Int): Int = {
      var nn = num
      var sum = 0
      while (nn != 0) {
        sum += nn % 10
        nn /= 10
      }
      sum
    }

    var ans = 0
    val visited = Array.fill(m, n)(false)
    (0 until m).foreach { i =>
      (0 until n).foreach { j =>
        if (numSum(i) + numSum(j) > k) visited(i)(j) = false
        else if (i == 0 && j == 0) visited(i)(j) = true
        else if (i == 0) visited(i)(j) = visited(i)(j - 1)
        else if (j == 0) visited(i)(j) = visited(i - 1)(j)
        else visited(i)(j) = visited(i - 1)(j) || visited(i)(j - 1)
        if (visited(i)(j)) ans += 1
      }
    }
    ans
  }
}