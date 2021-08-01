package me.ihainan

object P1104 {
  def log2(x: Int): Int = (math.log(x) / math.log(2)).toInt

  def sum(l: Int): Int = math.pow(2, l).toInt - 1

  def pathInZigZagTree(label: Int): List[Int] = {
    val ans = collection.mutable.ListBuffer.empty[Int]
    var num = label
    ans += num
    while (num != 1) {
      val next = num / 2
      val l = log2(next)
      num = sum(l + 1) - next + sum(l) + 1
      ans += num
    }
    ans.reverse.toList
  }
}