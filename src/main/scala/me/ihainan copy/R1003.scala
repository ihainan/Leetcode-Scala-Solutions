package me.ihainan

import scala.collection.mutable.{ListBuffer, Map}

object R1003 {
  def search(arr: Array[Int], target: Int): Int = {
    find(0, arr.length - 1, arr, target)
  }

  def find(l: Int, r: Int, nums: Array[Int], target: Int): Int = {
    if (l > r) -1
    else {
      val mid = (l + r) / 2
      if (nums(l) == target) l
      else if (nums(mid) == target) find(l, mid, nums, target)
      else if (nums(l) < nums(r)) {
        if (nums(mid) > target) find(l, mid - 1, nums, target)
        else find(mid + 1, r, nums, target)
      } else {
        val left = find(l, mid - 1, nums, target)
        if (left != -1) left
        else find(mid + 1, r, nums, target)
      }
    }
  }
}