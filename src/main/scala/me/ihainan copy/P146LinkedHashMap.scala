package me.ihainan

import java.util

object P146LinkedHashMap {

  class LRUCache(val _capacity: Int) extends util.LinkedHashMap[Int, Int](_capacity, 0.75f, true) {
    override def get(key: Any): Int = super.getOrDefault(key, -1)

    override def put(key: Int, value: Int): Int = super.put(key, value)

    override protected def removeEldestEntry(entry: util.Map.Entry[Int, Int]): Boolean = size() > _capacity
  }

}


/**
  * Your LRUCache object will be instantiated and called as such:
  * var obj = new LRUCache(capacity)
  * var param_1 = obj.get(key)
  * obj.put(key,value)
  */