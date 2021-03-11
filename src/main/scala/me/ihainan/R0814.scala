package me.ihainan

import collection.mutable.{ArrayBuffer, Map}

object R0814 {
  def countEval(s: String, result: Int): Int = {
    val nums = ArrayBuffer.empty[Int]
    val ops = ArrayBuffer.empty[Char]
    s.foreach {
      case c if c == '0' || c == '1' => nums += c - '0'
      case c => ops += c
    }
    solve(0, nums.length - 1, nums.toArray, ops.toArray, result, Map.empty[(Int, Int, Int), Int])
  }

  def solve(l: Int, r: Int, nums: Array[Int], ops: Array[Char], target: Int, memo: Map[(Int, Int, Int), Int]): Int = {
    if (l > r) 0
    else if (l == r) { if (nums(l) == target) 1 else 0 }
    else if (memo.isDefinedAt((l, r, target))) memo((l, r, target))
    else {
      val ans = (l + 1 to r).map { m =>
        val l0 = solve(l, m - 1, nums, ops, 0, memo)
        val l1 = solve(l, m - 1, nums, ops, 1, memo)
        val r0 = solve(m, r, nums, ops, 0, memo)
        val r1 = solve(m, r, nums, ops, 1, memo)
        ops(m - 1) match {
          case '&' => if (target == 1) l1 * r1 else l0 * r0 + l0 * r1 + l1 * r0
          case '|' => if (target == 1) l1 * r1 + l1 * r0 + l0 * r1 else l0 * r0
          case '^' => if (target == 1) l0 * r1 + l1 * r0 else l0 * r0 + l1 * r1
        }
      }.sum
      memo((l, r, target)) = ans
      ans
    }
  }
}