package me.ihainan

object P1449 {
  def largestNumber(costs: Array[Int], target: Int): String = {
    val dp = new Array[Boolean](target + 1)
    val nums = Array.fill(target + 1)("")
    dp(0) = true
    costs.indices.reverse.foreach { i =>
      val num = i + 1
      val cost = costs(i)
      (cost to target).foreach { j =>
        if (dp(j - cost)) {
          dp(j) = true
          val newStr = nums(j - cost) + num
          if (newStr.length > nums(j).length || (newStr.length == nums(j).length && newStr > nums(j))) {
            nums(j) = newStr
          }
        }
      }
    }

    if (nums(target) == "") "0" else nums(target)
  }
}