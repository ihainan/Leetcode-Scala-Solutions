package me.ihainan

object P969 {
  def pancakeSort(arr: Array[Int]): List[Int] = {
    def reverse(e: Int): Unit = {
      (0 to e / 2).foreach { i =>
        val tmp = arr(i)
        arr(i) = arr(e - i)
        arr(e - i) = tmp
      }
    }

    def findMax(e: Int): Int = {
      var max = 0
      (1 to e).foreach { j =>
        if (arr(j) > arr(max)) {
          max = j
        }
      }
      max
    }

    val ans = collection.mutable.ListBuffer.empty[Int]
    (arr.length - 1 to 0 by -1).foreach { e =>
      val maxI = findMax(e)
      if (maxI != e) {
        if (maxI != 0) {
          ans += maxI + 1
          reverse(maxI)
        }
        ans += e + 1
        reverse(e)
      }
    }
    ans.toList
  }
}