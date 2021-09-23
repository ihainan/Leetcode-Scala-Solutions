package me.ihainan

object R1710 {
  def majorityElement(nums: Array[Int]): Int = {
    val map = collection.mutable.Map.empty[Int, Int].withDefaultValue(0)
    nums.foreach { num => map(num) = map(num) + 1 }
    var (max, maxNum) = (0, 0)
    map.keys.foreach { key => if (map(key) > max) { maxNum = key; max = map(key) } }
    if (max > nums.length / 2) maxNum
    else -1
  }
}