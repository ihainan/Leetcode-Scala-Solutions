package me.ihainan

object P15 {
  def threeSum(nums: Array[Int]): List[List[Int]] = {
    val ans = collection.mutable.ListBuffer.empty[List[Int]]
    val sorted = nums.sorted
    sorted.indices.foreach { i =>
      if (i == 0 || sorted(i) != sorted(i - 1)) {
        val target = -sorted(i)
        var (j, k) = (i + 1, sorted.length - 1)
        while (j < k) {
          val sum = sorted(j) + sorted(k)
          if (sum == target) {
            if (
              (j == i + 1 || sorted(j) != sorted(j - 1)) &&
              (k == sorted.length - 1 || sorted(k) != sorted(k + 1))
            ) {
              ans += List(sorted(i), sorted(j), sorted(k))
            }
            j += 1
            k -= 1
          } else if (sum > target) {
            k -= 1
          } else {
            j += 1
          }
        }
      }
    }
    ans.toList
  }
}
