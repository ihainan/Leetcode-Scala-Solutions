package me.ihainan

object P1859 {
  def sortSentence(s: String): String = {
    s.split(" ")
      .map { str =>
        var j = str.length - 1
        while (j >= 0 && Character.isDigit(str(j))) j -= 1
        (str.substring(0, j + 1), str.substring(j + 1, str.length))
      }
      .sortBy(_._2)
      .map(_._1)
      .mkString(" ")
  }
}
