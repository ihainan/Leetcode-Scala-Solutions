object Solution {
  def canPermutePalindrome(s: String): Boolean = {
    val map = collection.mutable.Map.empty[Char, Int].withDefaultValue(0)
    s.foreach { c => map(c) = map(c) + 1 }
    map.keys.filter(k => map(k) % 2 == 1).size <= 1
  }
}
