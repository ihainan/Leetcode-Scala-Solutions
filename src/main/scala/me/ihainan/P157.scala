package me.ihainan

object P157 {
  class Reader4 {
    def read4(buf: Array[Char]): Int = 4
  }

  class Solution extends Reader4 {

    /** @param buf Destination buffer
      * @param n   Number of characters to read
      * @return    The number of actual characters read
      */
    def read(buf: Array[Char], n: Int): Int = {
      val buf4 = new Array[Char](4)
      var len = 0
      var readLen = read4(buf4)
      while (readLen != 0 && len != n) {
        val added = (n - len).min(readLen)
        System.arraycopy(buf4, 0, buf, len, added)
        len += added
        readLen = read4(buf4)
      }
      len
    }
  }
}
