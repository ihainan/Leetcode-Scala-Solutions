package me.ihainan

object P386Solution2 {

  def lexicalOrder(n: Int): List[Int] = {
    val ans = collection.mutable.ListBuffer.empty[Int]
    var current = 1
    var lastNum = 0
    (1 to n).foreach { _ =>
      ans += current
      if (current * 10 <= n) current *= 10
      else {
        while (current % 10 == 9 || current + 1 > n) current /= 10
        current += 1
      }
    }
    ans.toList
  }
}
