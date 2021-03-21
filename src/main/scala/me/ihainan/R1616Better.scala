package me.ihainan

object R1616Better {
  def subSort(array: Array[Int]): Array[Int] = {
    val ans = Array(-1, -1)
    var curMin = Int.MaxValue
    array.indices.reverse.foreach { i =>
      if (array(i) > curMin) ans(0) = i
      curMin = curMin.min(array(i))
    }
    var curMax = Int.MinValue
    array.indices.foreach { i =>
      if (array(i) < curMax) ans(1) = i
      curMax = curMax.max(array(i))
    }
    ans
  }
}