package me.ihainan.templates

object SegmentTree {
  class TreeNode(val start: Int, val end: Int, var max: Int) {
    var left: TreeNode = _
    var right: TreeNode = _
  }

  def findMax(node: TreeNode, s: Int, e: Int): Int = {
    if (node == null || s > e) Int.MinValue
    else if (s <= node.start && node.end <= e) node.max
    else {
      val m = (node.start + node.end) >>> 1
      var ans = Int.MinValue
      if (m >= s) ans = ans.max(findMax(node.left, s, e))
      if (m < e) ans = ans.max(findMax(node.right, s, e))
      ans
    }
  }

  def build(s: Int, e: Int, nums: Array[Int]): TreeNode = {
    if (s > e) null
    else {
      val root = new TreeNode(s, e, nums(s))
      if (s == e) return root
      val m = (s + e) >>> 1
      root.left = build(s, m, nums)
      root.right = build(m + 1, e, nums)
      root.max = root.left.max max root.right.max
      root
    }
  }

  def update(root: TreeNode, index: Int, value: Int): Unit = {
    if (root != null) {
      if (root.start == root.end) {
        if (root.start == index) root.max = value
      } else {
        val m = (root.start + root.end) >>> 1
        if (m >= index) update(root.left, index, value)
        else update(root.right, index, value)
        root.max = root.left.max max root.right.max
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val nums = Array(5, 2, 3, 1, 6)
    val root = build(0, nums.length - 1, nums)
    println(findMax(root, 1, 3))
    println(findMax(root, 3, 3))
    println(findMax(root, 0, 2))
    println(findMax(root, 0, 3))
    update(root, 3, 6)
    println(findMax(root, 1, 3))
    println(findMax(root, 3, 3))
    println(findMax(root, 0, 2))
    println(findMax(root, 0, 3))
    update(root, 3, 4)
    println(findMax(root, 1, 3))
    println(findMax(root, 3, 3))
    println(findMax(root, 0, 2))
    println(findMax(root, 0, 3))
  }
}
