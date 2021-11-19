package me.ihainan

object P167 {
  def twoSum(numbers: Array[Int], target: Int): Array[Int] = {
    var (i, j) = (0, numbers.length - 1)
    while (i < j) {
      val sum = numbers(i) + numbers(j)
      if (sum == target) return Array(i + 1, j + 1)
      else if (sum > target) j -= 1
      else i += 1
    }
    Array.empty[Int]
  }
}
