package me.ihainan

object P559 {
  def maxDepth(root: Node): Int = {
    if (root == null) 0
    else if (root.children.isEmpty) 1
    else root.children.map(child => maxDepth(child)).max + 1
  }
}
