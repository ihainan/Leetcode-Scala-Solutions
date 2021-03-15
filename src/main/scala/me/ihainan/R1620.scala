package me.ihainan

object R1620 {
  val map = Array('2', '2', '2',
    '3', '3', '3',
    '4', '4', '4',
    '5', '5', '5',
    '6', '6', '6',
    '7', '7', '7', '7',
    '8', '8', '8',
    '9', '9', '9', '9')

  def getValidT9Words(num: String, words: Array[String]): List[String] = {
    words.filter { word =>
      if (word.length != num.length) false
      else !word.indices.exists { i =>
        map(word(i) - 'a') != num(i)
      }
    }.toList
  }
}