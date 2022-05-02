package me.ihainan

object P591 {
  def isValid(code: String): Boolean = {
    val tags = collection.mutable.Stack.empty[String]
    val (isStart, s, e) = isTag(code, 0)
    if (e == -1 || !isStart) return false
    else tags.push(code.substring(1, e))
    var i = e + 1
    var lastTag = -1
    while (i < code.length) {
      if (code(i) == '<') {
        val (cs, ce) = isCData(code, i)
        if (ce != -1) {
          // println("CData = " + code.substring(cs, ce + 1))
          i = ce + 1
        } else {
          val (isStart, ts, te) = isTag(code, i)
          if (te == -1) return false
          // println("Full Tag = " + code.substring(ts, te + 1))
          if (isStart) {
            val tag = code.substring(ts + 1, te)
            // println("Tag = " + tag)
            tags.push(tag)
            i = te + 1
          } else {
            val tag = code.substring(ts + 2, te)
            // println("Tag = " + tag)
            if (tags.isEmpty || tags.head != tag) return false
            tags.pop
            i = te + 1
            if (tags.isEmpty && i != code.length) return false
            lastTag = te
          }
        }
      } else i += 1
    }

    tags.isEmpty && lastTag == code.length - 1
  }

  def isCData(code: String, s: Int): (Int, Int) = {
    if (s >= code.length - 11) return (-1, -1)
    if (code.substring(s, s + 9) != "<![CDATA[") return (-1, -1)
    var i = s + 9
    while (i <= code.length - 3) {
      if (code(i) == ']' && code(i + 1) == ']' && code(i + 2) == '>')
        return (s, i + 2)
      i += 1
    }
    (-1, -1)
  }

  def isTag(code: String, s: Int): (Boolean, Int, Int) = {
    if (s >= code.length - 3) return (false, -1, -1)
    val isStart = code(s + 1) != '/'
    val actualS = if (isStart) s + 1 else s + 2
    var i = actualS
    if (code(i) == '>') return (false, -1, -1)
    while (i < code.length && code(i) != '>') {
      if (code(i) < 'A' || code(i) > 'Z') return (false, -1, -1)
      if (i - actualS + 1 > 9) return (false, -1, -1)
      i += 1
    }
    if (i == code.length) (false, -1, -1)
    else (isStart, s, i)
  }
}
