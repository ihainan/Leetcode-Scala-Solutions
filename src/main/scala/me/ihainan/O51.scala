package me.ihainan

object O51 {
  def reversePairs(nums: Array[Int]): Int = {
    val sorted = nums.sorted
    val map = sorted.zipWithIndex.toMap
    val bit = new Array[Int](sorted.length + 1)
    var ans = 0

    nums.indices.reverse.foreach { i =>
      val index = map(nums(i))
      update(bit, index + 1, 1)
      if (index > 0) ans += sum(bit, index)
    }

    ans
  }

  @scala.annotation.tailrec
  def update(bit: Array[Int], i: Int, delta: Int): Unit = {
    if (i < bit.length) {
      bit(i) += delta
      update(bit, i + (i & -i), delta)
    }
  }

  def sum(bit: Array[Int], i: Int): Int = {
    if (i <= 0) 0
    else bit(i) + sum(bit, i - (i & -i))
  }
}