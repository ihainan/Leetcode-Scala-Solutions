package me.ihainan

object P372 {
  val MOD = 1337

  def mod(v: Long): Int = ((v % MOD + MOD) % MOD).toInt

  def superPow(a: Int, b: Array[Int]): Int = {
    def half(b: Array[Int]): Array[Int] = {
      var borrow = 0
      var start = -1

      b.indices.foreach { i =>
        val v = borrow * 10 + b(i)
        b(i) = v / 2
        borrow = v % 2
        if (start == -1 && b(i) != 0) start = i
      }

      if (start == -1) Array(0) else b.slice(start, b.length)
    }

    def pow(a: Int, b: Array[Int]): Int = {
      if (b.length == 1 && b(0) == 1) mod(a)
      else {
        val halfValue = half(b.clone)
        val powHalf = pow(a, halfValue)
        if (b.last % 2 == 0) mod(powHalf.toLong * powHalf)
        else mod(mod(powHalf.toLong * powHalf) * mod(a))
      }
    }

    pow(a, b)
  }
}
