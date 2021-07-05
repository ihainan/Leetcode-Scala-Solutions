package me.ihainan

object P249 {
  def groupStrings(strings: Array[String]): List[List[String]] = {
    val map = collection.mutable.Map.empty[String, List[String]].withDefaultValue(Nil)
    strings.foreach { str =>
      val chars = str.toCharArray
      val diff = chars(0) - 'a'
      chars.indices.foreach { i => chars(i) = ((chars(i) - diff + 26) % 26).toChar }
      val newStr = new String(chars)
      map(newStr) = map(newStr) :+ str
    }

    map.values.toList
  }
}
