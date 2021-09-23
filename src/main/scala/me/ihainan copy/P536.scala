package me.ihainan

object P536 {
  def str2tree(s: String): TreeNode = {
    str2tree(s, 0, s.length - 1)
  }

  def str2tree(s: String, l: Int, r: Int): TreeNode = {
    if (l > r) return null
    var i = l
    while (i <= r && s(i) != '(' && s(i) != ')') i += 1
    val root = new TreeNode(s.substring(l, i).toInt)
    val children = collection.mutable.ArrayBuffer.empty[TreeNode]
    while (i <= r) {
      var count = 1
      var j = i + 1
      while (count != 0) {
        if (s(j) == '(') count += 1
        else if (s(j) == ')') count -= 1
        j += 1
      }
      children += str2tree(s, i + 1, j - 2)
      i = j
    }

    if (children.length >= 1) root.left = children.head
    if (children.length >= 2) root.right = children.last
    root
  }
}
