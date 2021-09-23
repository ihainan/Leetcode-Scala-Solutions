package me.ihainan

object P604 {
  class StringIterator(_compressedString: String) {
    val store = collection.mutable.ArrayBuffer.empty[(Char, Int)]
    var current = 0
    prepare()

    def prepare(): Unit = {
      var i = 0
      while (i < _compressedString.length) {
        val c = _compressedString(i)
        var j = i + 1
        while (j < _compressedString.length && Character.isDigit(_compressedString(j))) j += 1
        val num = _compressedString.substring(i + 1, j).toInt
        store += ((c, num))
        i = j
      }
    }

    def next(): Char = {
      if (!hasNext) ' '
      else {
        val c = store(current)._1
        if (store(current)._2 == 1) current += 1
        else store(current) = (c, store(current)._2 - 1)
        c
      }
    }

    def hasNext(): Boolean = {
      current != store.length
    }

  }

  /**
    * Your StringIterator object will be instantiated and called as such:
    * var obj = new StringIterator(compressedString)
    * var param_1 = obj.next()
    * var param_2 = obj.hasNext()
    */
}