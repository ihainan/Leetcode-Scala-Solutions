package me.ihainan

object O44 {
  def findNthDigit(n: Int): Int = {
    if (n == 0) 0
    else {
      var nn = n.toLong
      var i = 1L
      while (nn > i * math.pow(10, i - 1).toLong * 9) {
        nn -= i * math.pow(10, i - 1).toLong * 9
        i += 1
      }
      val num = math.pow(10, i - 1).toLong + (nn - 1) / i
      num.toString.apply(((nn - 1) % i).toInt) - '0'
    }
  }
}