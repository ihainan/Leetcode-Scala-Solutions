package me.ihainan

object R1621 {
  def findSwapValues(array1: Array[Int], array2: Array[Int]): Array[Int] = {
    val sum1 = array1.sum
    val sum2 = array2.sum
    val s1 = array1.distinct.sorted
    val s2 = array2.distinct.sorted
    var (i, j) = (0, 0)
    while (i < s1.length && j < s2.length) {
      val t1 = sum1 - s1(i) + s2(j)
      val t2 = sum2 + s1(i) - s2(j)
      if (t1 == t2) return Array(s1(i), s2(j))
      else if (t1 > t2) i += 1
      else j += 1
    }
    Array()
  }
}