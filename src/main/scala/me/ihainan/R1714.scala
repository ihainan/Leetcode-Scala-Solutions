package me.ihainan

object R1714 {
  def smallestK(arr: Array[Int], k: Int): Array[Int] = {
    quickSort(0, arr.length - 1, arr, k)
    arr.slice(0, k)
  }

  def quickSort(l: Int, r: Int, nums: Array[Int], k: Int): Unit = {
    if (l < r) {
      val num = nums(l)
      var (i, j) = (l, r)
      while (i < j) {
        while (j > i && nums(j) > num) j -= 1;
        while (j > i && nums(i) <= num) i += 1
        swap(nums, i, j)
      }

      swap(nums, l, i)
      if (i > k) quickSort(l, i - 1, nums, k)
      else if (i < k) quickSort(i + 1, r, nums, k)
    }
  }

  def swap(nums: Array[Int], i: Int, j: Int): Unit = {
    val tmp = nums(i)
    nums(i) = nums(j)
    nums(j) = tmp
  }
}