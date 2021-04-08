package me.ihainan

object O40 {
  val random = new util.Random()

  def getLeastNumbers(arr: Array[Int], k: Int): Array[Int] = {
    firstK(arr, 0, arr.length - 1, k - 1)
    arr.slice(0, k)
  }

  def firstK(nums: Array[Int], l: Int, r: Int, k: Int): Unit = {
    if (l < r) {
      val tmp = nums(l)
      var (i, j) = (l, r)
      while (i < j) {
        while (i < j && nums(j) > tmp) j -= 1
        while (i < j && nums(i) <= tmp) i += 1
        swap(nums, i, j)
      }

      swap(nums, i, l)
      if (i > k) firstK(nums, l, i - 1, k)
      else if (i < k) firstK(nums, i + 1, r, k)
    }
  }

  def swap(nums: Array[Int], i: Int, j: Int): Unit = {
    val tmp = nums(i)
    nums(i) = nums(j)
    nums(j) = tmp
  }
}