package me.ihainan

/**
  * Definition for a binary tree node.
  * class TreeNode(var _value: Int) {
  *   var value: Int = _value
  *   var left: TreeNode = null
  *   var right: TreeNode = null
  * }
  */

import collection.mutable.Map

object R0412 {
  var ans = 0

  def pathSum(root: TreeNode, sum: Int): Int = {
    ans = 0
    solve(root, 0, sum, Map.empty[Int, Int].withDefaultValue(0))
    ans
  }

  def solve(root: TreeNode, sum: Int, target: Int, map: Map[Int, Int]): Unit = {
    if (root != null) {
      val newSum = sum + root.value
      ans += map(newSum - target)
      if (newSum == target) ans += 1
      map(newSum) = map(newSum) + 1
      solve(root.left, newSum, target, map)
      solve(root.right, newSum, target, map)
      map(newSum) = map(newSum) - 1 // don't forget to subtract 1
    }
  }
}