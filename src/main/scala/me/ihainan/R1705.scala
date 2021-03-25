package me.ihainan

object R1705 {
  def findLongestSubarray(array: Array[String]): Array[String] = {
    val digits = new Array[Int](array.length + 1)
    val alphabets = new Array[Int](array.length + 1)

    def isDigit(c: Char): Boolean = c >= '0' && c <= '9'

    array.indices.foreach { i =>
      val c = array(i)
      if (isDigit(c.head)) {
        digits(i + 1) = digits(i) + 1
        alphabets(i + 1) = alphabets(i)
      } else {
        digits(i + 1) = digits(i)
        alphabets(i + 1) = alphabets(i) + 1
      }
    }

    var (max, s, e) = (0, 0, 0)
    (0 until array.length - 1).foreach { i =>
      (i + 1 until array.length).foreach { j =>
        if (digits(j + 1) - digits(i) == alphabets(j + 1) - alphabets(i)) {
          if (j - i + 1 > max) {
            max = j - i + 1
            s = i
            e = j
          }
        }
      }
    }

    if (max == 0) Array()
    else array.slice(s, e + 1)
  }
}