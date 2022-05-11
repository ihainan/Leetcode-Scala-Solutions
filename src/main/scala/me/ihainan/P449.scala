package me.ihainan

object P449 {

  /** Definition for a binary tree node.
    * class TreeNode(var _value: Int) {
    *   var value: Int = _value
    *   var left: TreeNode = null
    *   var right: TreeNode = null
    * }
    */

  class Codec {
    import collection.mutable.ArrayBuffer

    // Encodes a list of strings to a single string.
    def serialize(root: TreeNode): String = {
      def preorder(node: TreeNode, list: ArrayBuffer[Int]): Unit = {
        if (node != null) {
          preorder(node.left, list)
          list += node.value
          preorder(node.right, list)
        }
      }

      def inorder(node: TreeNode, list: ArrayBuffer[Int]): Unit = {
        if (node != null) {
          list += node.value
          inorder(node.left, list)
          inorder(node.right, list)
        }
      }

      if (root == null) ""
      else {
        val preorderList = ArrayBuffer.empty[Int]
        val inorderList = ArrayBuffer.empty[Int]
        preorder(root, preorderList)
        inorder(root, inorderList)
        preorderList.mkString(",") + "\n" + inorderList.mkString(",")
      }
    }

    // Decodes a single string to a list of strings.
    def deserialize(data: String): TreeNode = {
      if (data == "") return null
      val preorderList = data.split("\n").head.split(",")
      val inorderList = data.split("\n").last.split(",")
      var currentIndex = 0
      val map = preorderList.zipWithIndex.toMap

      def buildTree(l: Int, r: Int): TreeNode = {
        if (l > r) null
        else {
          val value = inorderList(currentIndex)
          val root = new TreeNode(value.toInt)
          currentIndex += 1
          root.left = buildTree(l, map(value) - 1)
          root.right = buildTree(map(value) + 1, r)
          root
        }
      }

      buildTree(0, preorderList.length - 1)
    }
  }

  /** Your Codec object will be instantiated and called as such:
    * val ser = new Codec()
    * val deser = new Codec()
    * val tree: String = ser.serialize(root)
    * val ans = deser.deserialize(tree)
    * return ans
    */
}
