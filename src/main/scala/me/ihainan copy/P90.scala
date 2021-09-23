package me.ihainan

object P90 {
  def subsetsWithDup(nums: Array[Int]): List[List[Int]] = {
    dfs(nums.sorted, 0, lastChosen = true, Nil)
  }

  def dfs(nums: Array[Int], dep: Int, lastChosen: Boolean, path: List[Int]): List[List[Int]] = {
    if (nums.length == dep) List(path)
    else {
      if (dep > 0 && !lastChosen && nums(dep) == nums(dep - 1)) dfs(nums, dep + 1, lastChosen = false, path)
      else dfs(nums, dep + 1, lastChosen = true, path :+ nums(dep)) ::: dfs(nums, dep + 1, lastChosen = false, path)
    }
  }
}