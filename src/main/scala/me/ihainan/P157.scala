package me.ihainan

object P157 {

  class Reader4 {
    def read4(buf: Array[Char]): Int = 4
  }

  class Solution extends Reader4 {
    /**
      * @param buf Destination buffer
      * @param n   Number of characters to read
      * @return    The number of actual characters read
      */
    def read(buf: Array[Char], n: Int): Int = {
      val buf4 = new Array[Char](4)
      var (len, c) = (0, read4(buf4))
      while (len != n && c != 0) {
        (0 until c).foreach { i => buf(len + i) = buf4(i) }
        len = n.min(len + c)
        c = read4(buf4)
      }
      len
    }
  }

}
