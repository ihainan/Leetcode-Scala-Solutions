package me.ihainan

object P246 {
  def isStrobogrammatic(num: String): Boolean = {
    val set = Set("00", "11", "88", "69", "96")
    var (i, j) = (0, num.length - 1)
    while (i <= j) {
      if (!set("" + num(i) + num(j))) return false
      i += 1
      j -= 1
    }
    true
  }
}