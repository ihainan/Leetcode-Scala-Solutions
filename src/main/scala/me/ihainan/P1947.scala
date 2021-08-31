package me.ihainan

object P1947 {
  def swap(nums: Array[Int], i: Int, j: Int): Unit = {
    val tmp = nums(i)
    nums(i) = nums(j)
    nums(j) = tmp
  }

  def nextNums(nums: Array[Int]): Unit = {
    var i = nums.length - 2
    while (i >= 0 && nums(i) >= nums(i + 1)) i -= 1
    if (i >= 0) {
      var j = nums.length - 1
      while (nums(j) <= nums(i)) j -= 1
      swap(nums, i, j)
    }

    var (k, l) = (i + 1, nums.length - 1)
    while (k < l) {
      swap(nums, k, l)
      k += 1
      l -= 1
    }
  }

  def maxCompatibilitySum(students: Array[Array[Int]], mentors: Array[Array[Int]]): Int = {
    val map = collection.mutable.Map.empty[(Int, Int), Int]
    students.indices.foreach { i =>
      mentors.indices.foreach { j =>
        map((i, j)) = students(i).zip(mentors(j)).count { case (v1, v2) => v1 == v2 }
      }
    }

    val nums = students.indices.toArray
    var ans = 0
    (0 until (1 to students.length).product).foreach { _ =>
      ans = ans.max(mentors.indices.map(i => map(i, nums(i))).sum)
      nextNums(nums)
    }
    ans
  }
}