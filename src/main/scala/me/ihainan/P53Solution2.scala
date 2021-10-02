package me.ihainan

object P53Solution2 {
  class Node(
      val start: Int,
      val end: Int,
      var iSum: Int,
      var mSum: Int,
      var lSum: Int,
      var rSum: Int
  ) {
    var left: Node = _
    var right: Node = _
  }

  def buildTree(l: Int, r: Int, nums: Array[Int]): Node = {
    if (l > r) null
    else {
      val root = new Node(l, r, nums(l), nums(l), nums(l), nums(l))
      if (l == r) return root
      val m = (l + r) >>> 1
      root.left = buildTree(l, m, nums)
      root.right = buildTree(m + 1, r, nums)
      root.iSum = root.left.iSum + root.right.iSum
      root.lSum = root.left.lSum max (root.left.iSum + root.right.lSum)
      root.rSum = root.right.rSum max (root.right.iSum + root.left.rSum)
      root.mSum =
        root.left.mSum max root.right.mSum max (root.left.rSum + root.right.lSum)
      root
    }
  }

  def maxSubArray(nums: Array[Int]): Int = {
    val root = buildTree(0, nums.length - 1, nums)
    root.mSum
  }
}
