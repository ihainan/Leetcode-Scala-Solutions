package me.ihainan

object P251 {

  class Vector2D(_vec: Array[Array[Int]]) {
    val i1 = _vec.iterator
    var i2: Iterator[Int] = null
    while (i1.hasNext && (i2 == null || !i2.hasNext)) {
      i2 = i1.next.iterator
    }

    def next(): Int = {
      val value = i2.next
      while (i1.hasNext && !i2.hasNext) {
        i2 = i1.next.iterator
      }
      value
    }

    def hasNext(): Boolean = {
      i2 != null && i2.hasNext
    }

  }

  /**
    * Your Vector2D object will be instantiated and called as such:
    * var obj = new Vector2D(vec)
    * var param_1 = obj.next()
    * var param_2 = obj.hasNext()
    */

}