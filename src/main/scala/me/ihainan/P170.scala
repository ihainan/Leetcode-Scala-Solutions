package me.ihainan

object P170 {
  class TwoSum() {

    /** Initialize your data structure here. */
    val map = collection.mutable.Map.empty[Int, Int].withDefaultValue(0)

    /** Add the number to an internal data structure.. */
    def add(number: Int) = map(number) = map(number) + 1

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    def find(value: Int): Boolean = {
      map.exists { case (k, v) =>
        (value == k * 2 && map(k) >= 2) || (value != k * 2 && map(
          value - k
        ) != 0)
      }
    }

  }

  /** Your TwoSum object will be instantiated and called as such:
    * var obj = new TwoSum()
    * obj.add(number)
    * var param_2 = obj.find(value)
    */
}
