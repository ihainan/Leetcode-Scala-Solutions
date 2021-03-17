package me.ihainan

object R1625 {

  class LRUCache(_capacity: Int) {

    class Node(_k: Int, _x: Int) {
      val k = _k
      var x = _x
      var prev: Node = null
      var next: Node = null
    }

    val capacity = _capacity
    val head = new Node(0, 0)
    val tail = new Node(0, 0)
    head.next = tail
    tail.prev = head

    val map = collection.mutable.Map.empty[Int, Node]

    def insert(p: Node): Node = {
      val next = head.next
      next.prev = p
      p.next = next
      p.prev = head
      head.next = p
      p
    }

    def remove(p: Node): Node = {
      val next = p.next
      val prev = p.prev
      prev.next = next
      next.prev = prev
      p
    }

    def removeTail(): Node = {
      val prev = tail.prev
      if (prev == head) null
      else {
        val pprev = prev.prev
        pprev.next = tail
        tail.prev = pprev
        prev
      }
    }


    def get(key: Int): Int = {
      if (!map.isDefinedAt(key)) -1
      else {
        val p = insert(remove(map(key)))
        p.x
      }
    }

    def put(key: Int, value: Int) {
      if (map.isDefinedAt(key)) {
        val p = insert(remove(map(key)))
        p.x = value
      } else {
        val p = insert(new Node(key, value))
        map(key) = p
      }

      if (map.size > capacity) {
        val p = removeTail()
        map -= p.k
      }
    }

  }

  /**
    * Your LRUCache object will be instantiated and called as such:
    * var obj = new LRUCache(capacity)
    * var param_1 = obj.get(key)
    * obj.put(key,value)
    */
}