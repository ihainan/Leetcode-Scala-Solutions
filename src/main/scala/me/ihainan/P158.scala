package me.ihainan

object P158 {

  class Reader4 {
    def read4(buf: Array[Char]): Int = 4
  }

  class Solution extends Reader4 {
    val buf4 = new Array[Char](4)
    var buf2Read = 0
    var next2Read = 0

    /**
      * @param  buf Destination buffer
      * @param  n   Number of characters to read
      * @return     The number of actual characters read
      */
    def read(buf: Array[Char], n: Int): Int = {
      var len = 0
      if (buf2Read == 0) buf2Read = read4(buf4)
      while (len < n && buf2Read != 0) {
        val start = next2Read
        (start until buf2Read).foreach { i =>
          if (len + i - start < n) {
            buf(len + i - start) = buf4(i)
            next2Read = i + 1
          }
        }
        len = (len + buf2Read - start).min(n)
        if (next2Read == buf2Read) { // already read all the bytes from buf4
          next2Read = 0
          buf2Read = read4(buf4)
        }
      }
      len
    }
  }

}
