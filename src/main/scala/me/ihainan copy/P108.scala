package me.ihainan

object P108 {
  def sortedArrayToBST(nums: Array[Int]): TreeNode = {
    build(0, nums.length - 1, nums)
  }

  def build(l: Int, r: Int, nums: Array[Int]): TreeNode = {
    if (l > r) null
    else if (l == r) new TreeNode(nums(l))
    else {
      val mid = (l + r) >>> 1
      new TreeNode(nums(mid), build(l, mid - 1, nums), build(mid + 1, r, nums))
    }
  }
}