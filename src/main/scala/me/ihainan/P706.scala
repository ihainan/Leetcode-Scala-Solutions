package me.ihainan

object P706 {
  class MyHashMap() {
    import collection.mutable.ArrayBuffer
    val table = new Array[ArrayBuffer[(Int, Int)]](4000)
    val MOD = 4000

    def mod(v: Int) = (v + MOD) % MOD

    def put(key: Int, value: Int): Unit = {
      val hash = mod(key)
      if (table(hash) == null) {
        table(hash) = ArrayBuffer((key, value))
      } else {
        val index = table(hash).indices
          .collectFirst {
            case i if table(hash)(i)._1 == key => i
          }
          .getOrElse(-1)

        if (index == -1) table(hash) += ((key, value))
        else table(hash)(index) = ((key, value))
      }
    }

    def get(key: Int): Int = {
      val hash = mod(key)
      if (table(hash) == null) return -1
      val index = table(hash).indices
        .collectFirst {
          case i if table(hash)(i)._1 == key => i
        }
        .getOrElse(-1)
      if (index == -1) -1
      else table(hash)(index)._2
    }

    def remove(key: Int): Unit = {
      val hash = mod(key)
      if (table(hash) != null) {
        val index = table(hash).indices
          .collectFirst {
            case i if table(hash)(i)._1 == key => i
          }
          .getOrElse(-1)
        if (index != -1) {
          table(hash).remove(index)
        }
      }
    }

  }

  /** Your MyHashMap object will be instantiated and called as such: var obj =
    * new MyHashMap() obj.put(key,value) var param_2 = obj.get(key)
    * obj.remove(key)
    */
}
