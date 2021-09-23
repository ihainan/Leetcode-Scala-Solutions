package me.ihainan

object P896 {
  def isMonotonic(A: Array[Int]): Boolean = {
    A.length <= 1 || !(1 until A.length).exists(i => A(i) > A(i - 1)) || !(1 until A.length).exists(i => A(i) < A(i - 1))
  }
}