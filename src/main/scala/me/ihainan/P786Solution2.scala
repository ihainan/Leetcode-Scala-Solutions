package me.ihainan

object P786Solution2 {
  def kthSmallestPrimeFraction(arr: Array[Int], k: Int): Array[Int] = {
    val nums = {
      for {
        i <- arr.indices
        j <- i + 1 until arr.length
      } yield (arr(i), arr(j))
    }.toArray

    def calculate(tuple: (Int, Int)) = tuple._1 * 1.0 / tuple._2

    def swap(i: Int, j: Int): Unit = {
      val tmp = nums(i)
      nums(i) = nums(j)
      nums(j) = tmp
    }

    def quickFind(l: Int, r: Int): Unit = {
      if (l < r) {
        val tmp = calculate(nums(l))
        var (i, j) = (l, r)
        while (i < j) {
          while (i < j && calculate(nums(j)) > tmp) j -= 1
          while (i < j && calculate(nums(i)) <= tmp) i += 1
          swap(i, j)
        }

        swap(l, i)
        if (i > k - 1) quickFind(l, i - 1)
        else if (i < k - 1) quickFind(i + 1, r)
      }
    }

    quickFind(0, nums.length - 1)
    Array(nums(k - 1)._1, nums(k - 1)._2)
  }
}
