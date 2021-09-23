package me.ihainan

/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object R0402 {
  def sortedArrayToBST(nums: Array[Int]): TreeNode = {
    buildTree(0, nums.length - 1, nums)
  }

  def buildTree(l: Int, r: Int, nums: Array[Int]): TreeNode = {
    if (l > r) null
    else if (l == r) new TreeNode(nums(l))
    else {
      val mid = (l + r) / 2
      val root = new TreeNode(nums(mid))
      root.left = buildTree(l, mid - 1, nums)
      root.right = buildTree(mid + 1, r, nums)  
      root
    }
  }
}
