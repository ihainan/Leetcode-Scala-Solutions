package me.ihainan

object P1228 {
  def missingNumber(arr: Array[Int]): Int = {
    (arr.last + arr.head) * (arr.length + 1) / 2 - arr.sum
  }
}