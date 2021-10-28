package me.ihainan

object P869 {
  def reorderedPowerOf2(n: Int): Boolean = {
    val candicates = (0 to 30).map(i => (1 << i).toString.sorted)
    val sorted = n.toString.sorted
    candicates.exists(c => c.sameElements(sorted))
  }
}
