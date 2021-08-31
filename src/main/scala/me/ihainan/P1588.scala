package me.ihainan

object P1588 {
  def sumOddLengthSubarrays(arr: Array[Int]): Int = {
    var tmp = 0
    val sum = arr.map { num => tmp += num; tmp }
    var ans = 0
    arr.indices.foreach { i =>
      var len = 1
      while (i + len <= arr.length) {
        ans += sum(i + len - 1)
        if (i != 0) ans -= sum(i - 1)
        len += 2
      }
    }
    ans
  }
}
