package me.ihainan

object P288 {
  class ValidWordAbbr(_dictionary: Array[String]) {
    val map = collection.mutable.Map
      .empty[String, Set[String]]
      .withDefaultValue(Set.empty)
    _dictionary.foreach { word =>
      val wordAbbr = abbr(word); map(wordAbbr) = map(wordAbbr) + word
    }

    def abbr(word: String): String = {
      if (word.length <= 2) word
      else word.head + (word.length - 2).toString + word.last
    }

    def isUnique(word: String): Boolean = {
      val wordAbbr = abbr(word)
      !map.isDefinedAt(wordAbbr) || (map(wordAbbr).size == 1 && map(wordAbbr)(
        word
      ))
    }

  }

  /** Your ValidWordAbbr object will be instantiated and called as such:
    * var obj = new ValidWordAbbr(dictionary)
    * var param_1 = obj.isUnique(word)
    */

}
