package me.ihainan

object P645 {
  def findErrorNums(nums: Array[Int]): Array[Int] = {
    var set = (1 to nums.length).toSet
    val ans = new Array[Int](2)
    nums.foreach { num => 
      if (!set(num)) ans(0) = num
      set -= num
    }
    ans(1) = set.toArray.apply(0)
    ans
  }
}