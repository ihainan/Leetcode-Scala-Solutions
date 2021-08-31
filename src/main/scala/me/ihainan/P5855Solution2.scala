package me.ihainan

object P5855Solution2 {
  def kthLargestNumber(nums: Array[String], k: Int): String = {
    implicit val ordering = new Ordering[String] {
      def compare(v1: String, v2: String): Int = {
        if (v1.length == v2.length) v1 compare v2
        else if (v1.length > v2.length) 1
        else -1
      }
    }

    nums.sorted.apply(nums.length - k)
  }
}