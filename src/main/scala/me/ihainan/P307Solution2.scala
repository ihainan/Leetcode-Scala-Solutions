package me.ihainan

object P307Solution2 {
  class NumArray(_nums: Array[Int]) {
    class TreeNode(val start: Int, val end: Int, var sum: Int) {
      var left: TreeNode = _
      var right: TreeNode = _
    }

    def buildTree(s: Int, e: Int): TreeNode = {
      if (s > e) null
      else {
        val root = new TreeNode(s, e, _nums(s))
        if (s == e) return root
        val m = (s + e) >>> 1
        root.left = buildTree(s, m)
        root.right = buildTree(m + 1, e)
        root.sum = root.left.sum + root.right.sum
        root
      }
    }

    def find(node: TreeNode, s: Int, e: Int): Int = {
      if (s > e) 0
      else if (s <= node.start && node.end <= e) node.sum
      else {
        var sum = 0
        val m = (node.start + node.end) >>> 1
        if (s <= m) sum += find(node.left, s, e)
        if (e > m) sum += find(node.right, s, e)
        sum
      }
    }

    def update(node: TreeNode, index: Int, value: Int): Unit = {
      if (node != null) {
        if (node.start == node.end) {
          if (node.start == index) node.sum = value
        } else {
          val m = (node.start + node.end) >>> 1
          if (index <= m) update(node.left, index, value)
          else update(node.right, index, value)
          node.sum = node.left.sum + node.right.sum
        }
      }
    }

    val root = buildTree(0, _nums.length - 1)

    def update(index: Int, `val`: Int) {
      update(root, index, `val`)
    }

    def sumRange(left: Int, right: Int): Int = {
      find(root, left, right)
    }

  }

  /** Your NumArray object will be instantiated and called as such: var obj =
    * new NumArray(nums) obj.update(index,`val`) var param_2 =
    * obj.sumRange(left,right)
    */

}
