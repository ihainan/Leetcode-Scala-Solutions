package me.ihainan

object P701 {

  class TreeNode(
      _value: Int = 0,
      _left: TreeNode = null,
      _right: TreeNode = null
  ) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def insertIntoBST(root: TreeNode, `val`: Int): TreeNode = {
    if (root == null) new TreeNode(`val`)
    else {
      if (root.value > `val`) root.left = insertIntoBST(root.left, `val`)
      else root.right = insertIntoBST(root.right, `val`)
      root
    }
  }
}
