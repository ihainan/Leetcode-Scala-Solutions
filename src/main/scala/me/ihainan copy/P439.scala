package me.ihainan

object P439 {
  def parseTernary(expression: String): String = {
    def handle(l: Int, r: Int): String = {
      if (
        !(l to r).exists { i => expression(i) == '?' || expression(i) == ':' }
      ) expression.substring(l, r + 1)
      else {
        var i = l
        while (expression(i) != '?') i += 1
        val condition = handle(l, i - 1)
        var j = i
        var count = 1
        while (count != 0) {
          j += 1
          if (expression(j) == '?') count += 1
          else if (expression(j) == ':') count -= 1
        }
        if (condition == "T") handle(i + 1, j - 1)
        else handle(j + 1, r)
      }
    }

    handle(0, expression.length - 1)
  }
}
