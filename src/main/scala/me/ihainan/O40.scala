package me.ihainan

object O40 {
  def getLeastNumbers(arr: Array[Int], k: Int): Array[Int] = {
    def swap(i: Int, j: Int): Unit = {
      val tmp = arr(i)
      arr(i) = arr(j)
      arr(j) = tmp
    }

    def quickSort(l: Int, r: Int): Unit = {
      if (l < r) {
        val tmp = arr(l)
        var (i, j) = (l, r)
        while (i < j) {
          while (i < j && arr(j) > tmp) j -= 1
          while (i < j && arr(i) <= tmp) i += 1
          swap(i, j)
        }
        swap(l, i)
        if (i > k - 1) quickSort(l, i - 1)
        else if (i < k - 1) quickSort(i + 1, r)
      }
    }

    quickSort(0, arr.length - 1)
    arr.slice(0, k)
  }
}