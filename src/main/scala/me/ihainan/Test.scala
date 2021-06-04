package me.ihainan

object Test {
  def treeToDoublyList(root: TreeNode): TreeNode = {
    var prev: TreeNode = null
    var newRoot: TreeNode = null

    def visit(node: TreeNode): Unit = {
      if (node != null) {
        visit(node.left)
        node.left = prev
        if (prev == null) newRoot = node
        else prev.right = node
        prev = node
        visit(node.right)
      }
    }

    visit(root)
    newRoot
  }

  def main(args: Array[String]): Unit = {
    // [4,2,5,1,3]
    val nodes = Array(4, 2, 5, 1, 3).map(i => new TreeNode(i))
    nodes(0).left = nodes(1)
    nodes(0).right = nodes(2)
    nodes(1).left = nodes(3)
    nodes(1).right = nodes(4)
    val head = treeToDoublyList(nodes(0))
    println(head)
  }
}