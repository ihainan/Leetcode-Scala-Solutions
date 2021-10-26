package me.ihainan

object P496 {
  def nextGreaterElement(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    val map = nums2.zipWithIndex.toMap
    nums1.map { num =>
      (map(num) + 1 until nums2.length)
        .collectFirst {
          case i if nums2(i) > num => nums2(i)
        }
        .getOrElse(-1)
    }
  }
}
