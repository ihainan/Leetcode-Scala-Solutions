package me.ihainan

object R0804 {
  def subsets(nums: Array[Int]): List[List[Int]] = {
    visit(nums, 0, List.empty[Int])
  }

  def visit(nums: Array[Int], i: Int, path: List[Int]): List[List[Int]] = {
    if (i == nums.length) List(path)
    else visit(nums, i + 1, path :+ nums(i)) ::: visit(nums, i + 1, path)
  }
}