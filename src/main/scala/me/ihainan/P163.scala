package me.ihainan

object P163 {
  def findMissingRanges(nums: Array[Int], lower: Int, upper: Int): List[String] = {
    val nums2 = (lower - 1) +: nums :+ (upper + 1)
    (0 until nums2.length - 1).map { i =>
      if (nums2(i) >= nums2(i + 1) - 1) None
      else if (nums2(i) == nums2(i + 1) - 2) Some(s"${nums2(i) + 1}")
      else Some(s"${nums2(i) + 1}->${nums2(i + 1) - 1}")
    }.flatten.toList
  }
}