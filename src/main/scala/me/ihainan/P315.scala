package me.ihainan

object P315 {
  def countSmaller(nums: Array[Int]): List[Int] = {
    val tree = new Array[Int](20002) // 2 to 200002

    (nums.length - 1 to 0 by -1).map { k =>
      val num = nums(k) + 10000
      var sum = 0
      var i = num
      if (i > 0) {
        while (i > 0) {
          sum += tree(i)
          i -= (i & -i)
        }
      }

      i = num + 1
      while (i <= 20001) {
        tree(i) += 1
        i += (i & -i)
      }

      sum
    }.reverse.toList
  }
}