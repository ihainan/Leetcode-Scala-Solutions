object Solution {
  def compressString(S: String): String = {
    val sb = new StringBuilder()
    var count = 0
    var prev = ' '
    S.foreach { c => 
      if (c != prev) {
        if (count > 0) sb.append(prev + "" + count)
        count = 1
        prev = c
      } else {
        count += 1
      }
    }
    if (count > 0) sb.append(prev + "" + count)
    if (sb.length >= S.length) S
    else sb.toString
  }
}
