package me.ihainan

object P748 {
  def shortestCompletingWord(
      licensePlate: String,
      words: Array[String]
  ): String = {
    val countAlphabet = new Array[Int](26)
    licensePlate
      .filter(c => Character.isAlphabetic(c))
      .map(Character.toLowerCase _)
      .foreach(c => countAlphabet(c - 'a') += 1)
    var ans = ""
    var min = Int.MaxValue
    words.foreach { word =>
      val countWord = new Array[Int](26)
      word
        .filter(c => Character.isAlphabetic(c))
        .map(Character.toLowerCase _)
        .foreach(c => countWord(c - 'a') += 1)
      if ((0 until 26).forall(i => countWord(i) >= countAlphabet(i))) {
        if (min > word.length) {
          min = word.length
          ans = word
        }
      }
    }
    ans
  }
}
