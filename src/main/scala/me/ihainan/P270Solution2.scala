package me.ihainan

object P270Solution2 {
  def closestValue(root: TreeNode, target: Double): Int = {
    var prev: TreeNode = new TreeNode(Int.MinValue)
    var ans: Int = Int.MinValue

    def inorder(node: TreeNode): Unit = {
      if (node != null && ans == Int.MinValue) {
        inorder(node.left)
        if (target >= prev.value && target <= node.value) {
          if ((target - prev.value).abs < (node.value - target).abs) ans = prev.value
          else ans = node.value
        }
        prev = node
        inorder(node.right)
        "".split(",", -1)
      }
    }

    inorder(root)
    if (ans == Int.MinValue) prev.value else ans
  }
}