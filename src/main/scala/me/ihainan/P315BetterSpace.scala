package me.ihainan

object P315BetterSpace {
  def countSmaller(nums: Array[Int]): List[Int] = {
    val sorted = nums.toSet.toArray.sorted
    val tree = new Array[Int](sorted.length + 1)

    nums.indices.reverse.map { k =>
      val num = nums(k)
      val index = find(sorted, num, 0, sorted.length - 1)
      var sum = 0
      var i = index
      while (i > 0) {
        sum += tree(i)
        i -= (i & -i)
      }

      i = index + 1
      while (i < tree.length) {
        tree(i) += 1
        i += (i & -i)
      }
      sum
    }.toList.reverse
  }

  @scala.annotation.tailrec
  def find(nums: Array[Int], num: Int, l: Int, r: Int): Int = {
    if (l > r) -1
    else {
      val mid = (l + r) >>> 1
      if (nums(mid) == num) mid
      else if (nums(mid) > num) find(nums, num, l, mid - 1)
      else find(nums, num, mid + 1, r)
    }
  }
}