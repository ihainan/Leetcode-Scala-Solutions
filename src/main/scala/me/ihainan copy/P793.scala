package me.ihainan

object P793 {
  def getZeros(n: Long): Long = {
    var ans = 0L
    var d = 5L
    while (d <= n) {
      ans += (n / d)
      d *= 5
      if (d < 0) return ans
    }
    ans
  }

  @scala.annotation.tailrec
  def findLeft(l: Long, r: Long, K: Int): Long = {
    if (l > r) -1
    else if (getZeros(l) == K) l
    else {
      val mid = (l + r) >>> 1
      val zeros = getZeros(mid)
      if (zeros == K) findLeft(l + 1, mid, K)
      else if (zeros > K) findLeft(l + 1, mid - 1, K)
      else findLeft(mid + 1, r, K)
    }
  }

  @scala.annotation.tailrec
  def findRight(l: Long, r: Long, K: Int): Long = {
    if (l > r) -1
    else if (getZeros(r) == K) r
    else {
      val mid = (l + r) >>> 1
      val zeros = getZeros(mid)
      if (zeros == K) findRight(mid, r - 1, K)
      else if (zeros > K) findRight(l, mid - 1, K)
      else findRight(mid + 1, r - 1, K)
    }
  }

  def preimageSizeFZF(K: Int): Int = {
    val left = findLeft(0, Long.MaxValue, K)
    if (left == -1) 0
    else (findRight(0, Long.MaxValue, K) - left + 1).toInt
  }
}