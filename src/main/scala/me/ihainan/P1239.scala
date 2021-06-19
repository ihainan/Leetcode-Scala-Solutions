package me.ihainan

object P1239 {
  def maxLength(arr: List[String]): Int = {
    var ans = 0
    val masks = arr.map(str => getMask(str)).flatten

    def visit(depth: Int, len: Int, current: Int): Unit = {
      if (depth == masks.length) ans = ans.max(len)
      else {
        val (l, m) = masks(depth)
        if ((m & current) == 0) visit(depth + 1, len + l, current | m)
        visit(depth + 1, len, current)
      }
    }

    visit(0, 0, 0)
    ans
  }

  def getMask(str: String): Option[(Int, Int)] = {
    var mask = 0
    str.foreach { c =>
      val m = 1 << (c - 'a')
      if ((mask & m) != 0) return None
      else mask |= m
    }
    Some((str.length, mask))
  }  
}