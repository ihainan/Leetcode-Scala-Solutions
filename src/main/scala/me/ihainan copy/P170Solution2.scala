package me.ihainan

object P170Solution2 {
  class TwoSum() {

    /** Initialize your data structure here. */
    var nums = collection.mutable.ArrayBuffer.empty[Int]
    var isSorted = false

    /** Add the number to an internal data structure.. */
    def add(number: Int) = {
      nums += number
      isSorted = false
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    def find(value: Int): Boolean = {
      if (!isSorted) {
        nums = nums.sorted
        isSorted = true
      }

      var (l, r) = (0, nums.length - 1)
      while (l < r) {
        if (nums(l) + nums(r) == value) return true
        else if (nums(l) + nums(r) > value) r -= 1
        else l += 1
      }
      false
    }

  }

  /** Your TwoSum object will be instantiated and called as such:
    * var obj = new TwoSum()
    * obj.add(number)
    * var param_2 = obj.find(value)
    */
}
