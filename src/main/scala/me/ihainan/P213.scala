package me.ihainan

object P213 {
  def rob(nums: Array[Int]): Int = {
    if (nums.length == 1) return nums.head
    
    def calculate(a: Int, b: Int, f: Int, e: Int): Int = {
      var (aa, bb) = (a, b)
      (f to e).foreach { i =>
        val (t1, t2) = (bb + nums(i), aa max bb)
        aa = t1
        bb = t2
      }
      aa max bb
    }

    calculate(nums.head, 0, 1, nums.length - 2) max calculate(nums(1), 0, 2, nums.length - 1)
  }
}