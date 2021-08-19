package me.ihainan

object P1257 {
  class TreeNode(val name: String) {
    var parent: TreeNode = null
    var children: List[TreeNode] = Nil
  }

  def findSmallestRegion(
      regions: List[List[String]],
      region1: String,
      region2: String
  ): String = {
    val nameToNode =
      collection.mutable.Map.empty[String, TreeNode].withDefaultValue(null)

    regions.foreach { r =>
      val root = nameToNode.getOrElseUpdate(r(0), new TreeNode(r(0)))
      val children = (1 until r.length).map { i =>
        nameToNode.getOrElseUpdate(r(i), new TreeNode(r(i)))
      }
      children.foreach { _.parent = root }
      root.children = root.children ::: children.toList
    }

    def find(node: TreeNode, p: TreeNode, q: TreeNode): TreeNode = {
      if (node == null) null
      else if (node == p || node == q) node
      else {
        val found = node.children.map { c => find(c, p, q) }.filter(_ != null)
        if (found.size == 0) null
        else if (found.size == 1) found.head
        else node
      }
    }

    val root = nameToNode.values.filter(_.parent == null).head
    find(root, nameToNode(region1), nameToNode(region2)).name
  }
}
