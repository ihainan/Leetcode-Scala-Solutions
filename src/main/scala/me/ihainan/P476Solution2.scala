package me.ihainan

object P476Solution2 {
  def findComplement(num: Int): Int = {
    val num2 = (30 to 0 by -1)
      .collectFirst { case i if num >= (1 << i) => (1 << (i + 1)) - 1 }
      .getOrElse(0x7fffffff)
    num ^ num2
  }
}
