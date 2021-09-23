package me.ihainan

object P89 {
  def setZero(num: Int, i: Int): Int = num & (-1 ^ (1 << i))

  def setOne(num: Int, i: Int): Int = num | (1 << i)

  def grayCode(n: Int): List[Int] = {
    val ans = collection.mutable.ListBuffer(0)
    val set = collection.mutable.Set(0)
    val count = math.pow(2, n).toInt

    def getNext(num: Int): Int = {
      (0 until n).foreach { i =>
        val mask = 1 << i
        val newNum = if ((num & mask) == 0) setOne(num, i) else setZero(num, i)
        if (!set(newNum)) return newNum
      }
      0
    }

    while (ans.size != count) {
      val next = getNext(ans.last)
      set += next
      ans += next
    }

    ans.toList
  }
}