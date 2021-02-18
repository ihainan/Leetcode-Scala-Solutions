object Solution {
  def isUnique(astr: String): Boolean = {
    var num = 0
    !astr.exists { c =>
      val v = c - 'a'
      val mask = 1 << v
      if ((mask & num) == mask) true
      else {
        num |= mask
        false
      }
    }
  }
}
