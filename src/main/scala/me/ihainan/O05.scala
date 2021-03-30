package me.ihainan

object O05 {
  def replaceSpace(s: String): String = {
    if (s.isEmpty) ""
    else {
      val spaces = s.count(_ == ' ')
      val arr = new Array[Char](s.length + spaces * 2)
      var i = 0
      s.foreach { c =>
        if (c == ' ') {
          arr(i) = '%'
          arr(i + 1) = '2'
          arr(i + 2) = '0'
          i += 3
        } else {
          arr(i) = c
          i += 1
        }
      }
      new String(arr)
    }
  }
}