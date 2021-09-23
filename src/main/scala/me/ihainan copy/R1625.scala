package me.ihainan

object R1625 {

  class LRUCache(_capacity: Int) {
    case class Node(k: Int, v: Int) {
      var next: Node = _
      var prev: Node = _
    }

    val dummy = Node(-1, -1)
    var tail = dummy
    val map = collection.mutable.Map.empty[Int, Node]

    def addNode(node: Node): Unit = {
      val next = dummy.next
      node.prev = dummy
      node.next = next
      dummy.next = node
      if (next != null) next.prev = node
      else tail = node
    }

    def removeNode(node: Node): Unit = {
      val (next, prev) = (node.next, node.prev)
      prev.next = next
      if (next != null) next.prev = prev
      else tail = prev
    }

    def get(key: Int): Int = {
      if (!map.isDefinedAt(key)) -1
      else {
        removeNode(map(key))
        addNode(map(key))
        map(key).v
      }
    }

    def put(key: Int, value: Int) {
      val newNode = Node(key, value)
      if (map.isDefinedAt(key)) removeNode(map(key))
      addNode(newNode)
      map(key) = newNode
      if (map.size > _capacity) {
        map -= tail.k
        removeNode(tail)
      }
    }

  }

  /** Your LRUCache object will be instantiated and called as such: var obj =
    * new LRUCache(capacity) var param_1 = obj.get(key) obj.put(key,value)
    */
}
