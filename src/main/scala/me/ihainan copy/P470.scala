package me.ihainan

object P470 {
  val random = new util.Random()

  def rand7(): Int = random.nextInt(7) + 1

  def lessThan(n: Int): Int = {
    while (true) {
      val r = rand7()
      if (r < n) return r
    }
    n
  }

  def rand10(): Int = {
    if (lessThan(7) <= 3) lessThan(6) else 5 + lessThan(6)
  }
}