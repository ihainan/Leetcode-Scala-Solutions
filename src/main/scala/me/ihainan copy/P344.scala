package me.ihainan

object P344 {
  def reverseString(s: Array[Char]): Unit = {
    val len = s.length
    (0 to (len - 1) / 2).foreach { i =>
      val tmp = s(i)
      s(i) = s(len - i - 1)
      s(len - i - 1) = tmp
    }
  }
}