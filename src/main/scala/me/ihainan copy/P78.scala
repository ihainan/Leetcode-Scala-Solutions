package me.ihainan

object P78 {
  def subsets(nums: Array[Int]): List[List[Int]] = {
    dfs(nums, 0, Nil)
  }

  def dfs(nums: Array[Int], i: Int, path: List[Int]): List[List[Int]] = {
    if (i == nums.length) List(path)
    else dfs(nums, i + 1, path) ::: dfs(nums, i + 1, path :+ nums(i))
  }
}