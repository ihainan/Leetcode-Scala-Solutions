package me.ihainan

object P284 {
// Scala Iterator reference:
// https://www.scala-lang.org/api/2.12.2/scala/collection/Iterator.html

  class PeekingIterator(_iterator: Iterator[Int]) {
    var keepValue: Option[Int] = None

    def peek(): Int = {
      if (keepValue.isEmpty) keepValue = Some(_iterator.next)
      keepValue.get
    }

    def next(): Int = {
      if (keepValue.isEmpty) _iterator.next
      else {
        val v = keepValue.get
        keepValue = None
        v
      }
    }

    def hasNext(): Boolean = {
      keepValue.nonEmpty || _iterator.hasNext
    }
  }

  /** Your PeekingIterator object will be instantiated and called as such:
    * var obj = new PeekingIterator(arr)
    * var param_1 = obj.next()
    * var param_2 = obj.peek()
    * var param_3 = obj.hasNext()
    */
}
