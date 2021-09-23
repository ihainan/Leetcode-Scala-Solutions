package me.ihainan

object P446 {
  def numberOfArithmeticSlices(nums: Array[Int]): Int = {
    val len = nums.length
    val seqs = Array.fill(len)(collection.mutable.Map.empty[Long, Int].withDefaultValue(0))
    (1 until len).foreach { j =>
      (0 until j).foreach { i =>
        val diff = nums(j).toLong - nums(i)
        seqs(j)(diff) = seqs(j)(diff) + seqs(i)(diff) + 1
      }
    }
    seqs.map(_.values.sum).sum - len * (len - 1) / 2
  }
}