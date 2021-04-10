package me.ihainan

object O33 {
  def verifyPostorder(postorder: Array[Int]): Boolean = {
    verify(postorder, 0, postorder.length - 1)
  }

  def verify(nums: Array[Int], l: Int, r: Int): Boolean = {
    if (l >= r) true
    else {
      var i = l
      while (nums(i) < nums(r)) i += 1
      val m = i
      while (nums(i) > nums(r)) i += 1
      i == r && verify(nums, l, m - 1) && verify(nums, m, r - 1)
    }
  }
}