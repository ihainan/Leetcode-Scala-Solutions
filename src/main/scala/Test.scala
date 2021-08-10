object Solution {
  def numberOfArithmeticSlices(nums: Array[Int]): Int = {
    var (ans, i) = (0, 0)
    while (i <= nums.length - 3) {
      var j = i + 2
      while (j < nums.length && nums(j) - nums(j - 1) == nums(i + 1) - nums(i)) j += 1
      ans += (j - i - 1) * (j - i - 2) / 2
      i = j - 1
    }
    ans
  }
}