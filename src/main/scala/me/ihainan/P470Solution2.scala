package me.ihainan

object P470Solution2 {
  val random = new util.Random()

  def rand7(): Int = random.nextInt(7) + 1

  def rand10(): Int = {
    var r = (rand7() - 1) * 7 + rand7()
    while (r > 40) r = (rand7() - 1) * 7 + rand7()
    (r % 10) + 1
  }
}
