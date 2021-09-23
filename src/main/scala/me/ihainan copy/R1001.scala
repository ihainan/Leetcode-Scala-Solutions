package me.ihainan

object R1001 {
  def merge(A: Array[Int], m: Int, B: Array[Int], n: Int): Unit = {
    var (i, j, k) = (m - 1, n - 1, A.length - 1)
    while (i >= 0 || j >= 0) {
      if (i < 0 || (j >= 0 && A(i) < B(j))) {
        A(k) = B(j)
        j -= 1
      } else {
        A(k) = A(i)
        i -= 1
      }
      k -= 1
    }
  }
}