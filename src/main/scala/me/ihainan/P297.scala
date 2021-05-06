package me.ihainan

object P297 {

  class Codec {

    import collection.mutable._

    // Encodes a list of strings to a single string.
    def serialize(root: TreeNode): String = {
      if (root == null) ""
      else {
        val queue = Queue.empty[TreeNode]
        val list = ListBuffer.empty[String]
        queue.enqueue(root)
        while (queue.nonEmpty) {
          val node = queue.dequeue
          if (node == null) list += "x"
          else {
            list += node.value.toString
            queue.enqueue(node.left)
            queue.enqueue(node.right)
          }
        }
        list.mkString(",")
      }
    }

    // Decodes a single string to a list of strings.
    def deserialize(data: String): TreeNode = {
      if (data == "") null
      else {
        val list = data.split(",")
        val queue = Queue.empty[TreeNode]
        val root = buildNode(list.head)
        var i = 1
        queue.enqueue(root)
        while (queue.nonEmpty) {
          val level = ListBuffer.empty[TreeNode]
          while (queue.nonEmpty) level += queue.dequeue
          level.foreach { node =>
            node.left = buildNode(list(i))
            i += 1
            node.right = buildNode(list(i))
            i += 1
            if (node.left != null) queue.enqueue(node.left)
            if (node.right != null) queue.enqueue(node.right)
          }
        }
        root
      }
    }

    def buildNode(str: String): TreeNode = {
      if (str == "x") null // should be string "x"
      else new TreeNode(str.toInt)
    }
  }

  /**
    * Your Codec object will be instantiated and called as such:
    * var ser = new Codec()
    * var deser = new Codec()
    * val s = ser.serialize(root)
    * val ans = deser.deserialize(s)
    */
}