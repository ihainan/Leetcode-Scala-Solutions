package me.ihainan

object P31 {
  def nextPermutation(nums: Array[Int]): Unit = {
    val index = (nums.length - 1 to 1 by -1).collectFirst {
      case i if nums(i) > nums(i - 1) => i - 1
    }.getOrElse(-1)

    if (index == -1) util.Sorting.quickSort(nums)
    else {
      val larger = (nums.length - 1 to index + 1 by -1).collectFirst {
        case i if (nums(i) > nums(index)) => i
      }.getOrElse(index)

      val tmp = nums(index)
      nums(index) = nums(larger)
      nums(larger) = tmp

      val newNums = (index + 1 until nums.length).map(i => nums(i))
      val sorted = newNums.sorted
      sorted.indices.foreach(i => nums(index + i + 1) = sorted(i))
    }
  }
}