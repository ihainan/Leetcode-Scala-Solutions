package me.ihainan

object P229 {
  def majorityElement(nums: Array[Int]): List[Int] = {
    val size = nums.length / 3
    val map = collection.mutable.Map.empty[Int, Int].withDefaultValue(0)
    val ans = collection.mutable.ListBuffer.empty[Int]
    nums.foreach(num => map(num) = map(num) + 1)
    map.foreach { case (k, v) => if (v > size) ans += k }
    ans.toList
  }
}
