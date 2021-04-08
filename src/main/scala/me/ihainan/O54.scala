package me.ihainan

object O54 {
  def kthLargest(root: TreeNode, k: Int): Int = {
    var count = 0
    var ans: Option[Int] = None

    def find(root: TreeNode, k: Int): Unit = {
      if (root != null && ans.isEmpty) {
        find(root.right, k)
        if (ans.isEmpty) {
          count += 1
          if (count == k) ans = Some(root.value)
          else find(root.left, k)
        }
      }
    }

    find(root, k)
    ans.get
  }
}