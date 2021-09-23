package me.ihainan

object O37Scala {

  /**
    * Definition for a binary tree node.
    * class TreeNode(var _value: Int) {
    *   var value: Int = _value
    *   var left: TreeNode = null
    *   var right: TreeNode = null
    * }
    */

  class Codec {

    import collection.mutable._

    // Encodes a list of strings to a single string.
    def serialize(root: TreeNode): String = {
      if (root == null) ""
      else {
        val queue = Queue(root)
        val list = ListBuffer.empty[TreeNode]
        while (queue.nonEmpty) {
          val node = queue.dequeue
          list += node
          if (node != null) {
            queue.enqueue(node.left)
            queue.enqueue(node.right)
          }
        }
        list.map(node => if (node == null) 'x' else node.value.toString).mkString(",")
      }
    }

    // Decodes a single string to a list of strings.
    def deserialize(data: String): TreeNode = {
      // [1,2,3,null,null,4,5]
      def buildNode(str: String): TreeNode = if (str == "x") null else new TreeNode(str.toInt)

      if (data == "") null
      else {
        val list = data.split(",")
        val root = buildNode(list(0))
        var i = 1
        val queue = Queue(root)
        while (queue.nonEmpty) {
          val node = queue.dequeue()
          node.left = buildNode(list(i))
          i += 1
          node.right = buildNode(list(i))
          i += 1
          if (node.left != null) queue.enqueue(node.left)
          if (node.right != null) queue.enqueue(node.right)
        }
        root
      }
    }
  }

}

/**
  * Your Codec object will be instantiated and called as such:
  * var ser = new Codec()
  * var deser = new Codec()
  * val s = ser.serialize(root)
  * val ans = deser.deserialize(s)
  */