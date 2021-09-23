package me.ihainan

object R1602HashMap {

  class WordsFrequency(_book: Array[String]) {
    val map = collection.mutable.Map.empty[String, Int].withDefaultValue(0)
    _book.foreach { str => map(str) = map(str) + 1 }

    def get(word: String): Int = {
      map(word)
    }

  }
}