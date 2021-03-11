package me.ihainan

object P88 {
  def merge(nums1: Array[Int], m: Int, nums2: Array[Int], n: Int): Unit = {
    var (i, j, k) = (m - 1, nums2.length - 1, nums1.length - 1)
    while (i >= 0 || j >= 0){
      if (i < 0 || (j >= 0 && nums1(i) < nums2(j))) {
        nums1(k) = nums2(j)
        j -= 1
      } else {
        nums1(k) = nums1(i)
        i -= 1
      }
      k -= 1
    }
  }
}