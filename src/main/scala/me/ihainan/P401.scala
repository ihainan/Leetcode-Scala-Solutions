package me.ihainan

object P401 {
  def readBinaryWatch(turnedOn: Int): List[String] = {
    val ans = collection.mutable.ListBuffer.empty[String]

    def helper(depth: Int, num: Int, turnedOn: Int, target: Int, maxDepth:Int, maxValue: Int): List[Int] = {
      if (num > maxValue || turnedOn + (maxDepth - depth) < target) Nil
      else if (depth == maxDepth) {
        if (turnedOn == target) List(num)
        else Nil
      } else {
        helper(depth + 1, num | (1 << depth), turnedOn + 1, target, maxDepth, maxValue) ::: helper(depth + 1, num, turnedOn, target, maxDepth, maxValue)
      }
    }

    (0 to (turnedOn.min(4))).foreach { i =>
      val j = turnedOn - i
      if (j >= 0 && j <= 6) {
        val l1 = helper(0, 0, 0, i, 4, 11)
        val l2 = helper(0, 0, 0, j, 6, 59)
        l1.foreach { h =>
          l2.foreach { m =>
            ans += f"$h:$m%02d"
          }
        }
      }
    }
    ans.toList
  }
}