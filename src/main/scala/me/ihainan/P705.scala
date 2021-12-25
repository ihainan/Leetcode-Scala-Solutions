package me.ihainan

object P705 {
  class MyHashSet() {
    val MOD = 4000

    def mod(v: Int): Int = (v + MOD) % MOD

    val table = Array.fill(MOD)(collection.mutable.ArrayBuffer.empty[Int])

    def getInex(key: Int): (Int, Int) = {
      val hash = mod(key)
      val index = table(hash).indices
        .collectFirst {
          case i if table(hash)(i) == key => i
        }
        .getOrElse(-1)
      (hash, index)
    }

    def add(key: Int): Unit = {
      val (hash, index) = getInex(key)
      if (index == -1) table(hash) += key
    }

    def remove(key: Int): Unit = {
      val (hash, index) = getInex(key)
      if (index != -1) table(hash).remove(index)
    }

    def contains(key: Int): Boolean = {
      val (hash, index) = getInex(key)
      index != -1
    }

  }

  /** Your MyHashSet object will be instantiated and called as such: var obj =
    * new MyHashSet() obj.add(key) obj.remove(key) var param_3 =
    * obj.contains(key)
    */
}
