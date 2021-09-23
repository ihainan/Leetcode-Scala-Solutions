package me.ihainan

object O03Set {
  def findRepeatNumber(nums: Array[Int]): Int = {
    val set = collection.mutable.Set.empty[Int]
    nums.foreach { num => if (set(num)) return num; set += num }
    0
  }
}