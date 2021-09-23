package me.ihainan

object P270 {
  def closestValue(root: TreeNode, target: Double): Int = {
    var ans = root.value

    @scala.annotation.tailrec
    def find(node: TreeNode): Unit = {
      if (node != null) {
        if ((ans - target).abs > (node.value - target).abs) ans = node.value
        if (node.value > target) find(node.left)
        else if (node.value < target) find(node.right)
      }
    }

    find(root)
    ans
  }
}