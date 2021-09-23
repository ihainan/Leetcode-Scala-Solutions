package me.ihainan

object P68 {
  def fullJustify(words: Array[String], maxWidth: Int): List[String] = {
    def findLastWord(i: Int): Int = {
      var j = i + 1
      var len = words(i).length + 1
      while (j < words.length && len + words(j).length <= maxWidth) {
        len += words(j).length + 1
        j += 1
      }
      j - 1
    }

    val lineIndices = collection.mutable.ListBuffer.empty[(Int, Int)]
    def getLine(i: Int, j: Int, l: Int): String = {
      if (l == lineIndices.length - 1) {
        val line = (i to j).map(k => words(k)).mkString(" ")
        line + " " * (maxWidth - line.length)
      } else if (i == j) {
        words(i) + " " * (maxWidth - words(i).length)
      } else {
        var rest = maxWidth - words(j).length -
          (i until j).map(k => words(k).length + 1).sum
        val sb = new StringBuilder()
        (i until j).foreach { k =>
          val average = math.ceil(rest * 1.0 / (j - k)).toInt
          sb.append(words(k) + " ")
          sb.append(" " * (rest.min(average)))
          rest -= rest.min(average)
        }
        sb.append(words(j))
        sb.toString
      }
    }

    var i = 0
    while (i < words.length) {
      val j = findLastWord(i)
      lineIndices += ((i, j))
      i = j + 1
    }

    lineIndices.indices
      .map(l => getLine(lineIndices(l)._1, lineIndices(l)._2, l))
      .toList
  }
}
