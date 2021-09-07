package me.ihainan

object P428 {
  class Node(var _value: Int) {
    var value: Int = _value
    var children: List[Node] = Nil
  }

  /** Definition for a Node. class Node(var _value: Int) { var value: Int =
    * _value var children: List[Node] = List() }
    */

  class Codec {
    // Encodes a tree to a single string.
    def serialize(root: Node): String = {
      if (root == null) ""
      else
        s"${root.value}${root.children.map(c => "(" + serialize(c) + ")").mkString}"
    }

    // Decodes your encoded data to tree.
    def deserialize(data: String): Node = {
      // println(data)
      deserialize(data, 0, data.length - 1)
    }

    // "2(1(2)(3))(4)"
    def deserialize(s: String, l: Int, r: Int): Node = {
      if (l > r) null
      else {
        var i = l
        while (i <= r && s(i) != '(' && s(i) != ')') i += 1
        val root = new Node(s.substring(l, i).toInt)
        val children = collection.mutable.ListBuffer.empty[Node]
        while (i <= r) {
          var j = i + 1
          var count = 1
          while (count != 0) {
            if (s(j) == '(') count += 1
            if (s(j) == ')') count -= 1
            j += 1
          }
          children += deserialize(s, i + 1, j - 2)
          i = j
        }
        root.children = children.toList
        root
      }
    }
  }

  /** Your Codec object will be instantiated and called as such: var obj = new
    * Codec() var data = obj.serialize(root) var ans = obj.deserialize(data)
    */
}
