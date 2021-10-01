package me.ihainan

object P308Solution2 {
  class NumMatrix(_matrix: Array[Array[Int]]) {
    class Node(val start: Int, val end: Int, var sum: Int) {
      var left: Node = _
      var right: Node = _
    }

    class SegmentTree(val nums: Array[Int]) {
      def buildTree(l: Int, r: Int): Node = {
        if (l > r) null
        else {
          val root = new Node(l, r, nums(l))
          if (l == r) return root
          val m = (l + r) >>> 1
          root.left = buildTree(l, m)
          root.right = buildTree(m + 1, r)
          root.sum = root.left.sum + root.right.sum
          root
        }
      }

      val root = buildTree(0, nums.length - 1)

      def find(l: Int, r: Int): Int = find(root, l, r)

      def find(node: Node, l: Int, r: Int): Int = {
        if (l <= node.start && node.end <= r) node.sum
        else {
          val m = (node.start + node.end) >>> 1
          var sum = 0
          if (l <= m) sum += find(node.left, l, r)
          if (m < r) sum += find(node.right, l, r)
          sum
        }
      }

      def update(index: Int, value: Int): Unit = update(root, index, value)

      def update(node: Node, index: Int, value: Int): Unit = {
        if (node != null) {
          if (node.start == node.end) {
            if (node.start == index) {
              node.sum = value
            }
          } else {
            val m = (node.start + node.end) >>> 1
            if (m >= index) update(node.left, index, value)
            else update(node.right, index, value)
            node.sum = node.left.sum + node.right.sum
          }
        }
      }
    }

    val trees = _matrix.map(nums => new SegmentTree(nums))

    def update(row: Int, col: Int, `val`: Int) {
      trees(row).update(col, `val`)
    }

    def sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int = {
      (row1 to row2).map { row => trees(row).find(col1, col2) }.sum
    }

  }

  /** Your NumMatrix object will be instantiated and called as such: var obj =
    * new NumMatrix(matrix) obj.update(row,col,`val`) var param_2 =
    * obj.sumRegion(row1,col1,row2,col2)
    */
}
