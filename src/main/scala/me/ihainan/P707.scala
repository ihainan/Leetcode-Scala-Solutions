package me.ihainan

/** Definition for a binary tree node. class TreeNode(var _value: Int) { var
  * value: Int = _value var left: TreeNode = null var right: TreeNode = null }
  */
object P707 {
  class MyLinkedList() {
    class Node(val x: Int) {
      var next: Node = _
    }

    var size = 0
    val dummy = new Node(0)

    def get(index: Int): Int = {
      if (index >= size) -1
      else {
        var p = dummy
        (0 to index).foreach(_ => p = p.next)
        p.x
      }
    }

    def addAtHead(`val`: Int) {
      val node = new Node(`val`)
      node.next = dummy.next
      dummy.next = node
      size += 1
    }

    def addAtTail(`val`: Int) {
      var p = dummy
      while (p.next != null) p = p.next
      val node = new Node(`val`)
      p.next = node
      size += 1
    }

    def addAtIndex(index: Int, `val`: Int) {
      if (index <= size) {
        var p = dummy
        (0 until index).foreach(_ => p = p.next)
        val node = new Node(`val`)
        node.next = p.next
        p.next = node
        size += 1
      }
    }

    def deleteAtIndex(index: Int) {
      if (index < size) {
        var p = dummy
        (0 until index).foreach(_ => p = p.next)
        p.next = p.next.next
        size -= 1
      }
    }

  }

  /** Your MyLinkedList object will be instantiated and called as such: var obj
    * = new MyLinkedList() var param_1 = obj.get(index) obj.addAtHead(`val`)
    * obj.addAtTail(`val`) obj.addAtIndex(index,`val`) obj.deleteAtIndex(index)
    */
}
