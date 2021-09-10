package me.ihainan

object P1894 {
  def chalkReplacer(chalk: Array[Int], k: Int): Int = {
    var tmp = 0
    val sum = chalk.indices.map { i =>
      tmp += chalk(i);
      if (tmp > k) return i
      tmp
    }
    val rest = k % sum.last

    @annotation.tailrec
    def find(l: Int, r: Int): Int = {
      if (l > r) -1
      else if (sum(l) > rest) l
      else {
        val m = (l + r) >>> 1
        if (sum(m) > rest) find(l + 1, m)
        else find(m + 1, r)
      }
    }

    find(0, chalk.length - 1)
  }
}