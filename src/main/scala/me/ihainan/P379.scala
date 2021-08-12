package me.ihainan

object P379 {
  class PhoneDirectory(_maxNumbers: Int) {
    import collection.mutable

    /** Initialize your data structure here
      * @param maxNumbers
      *   - The maximum numbers that can be stored in the phone directory.
      */
    val maxNumbers = _maxNumbers
    val unused = mutable.Set(0 until maxNumbers: _*)

    /** Provide a number which is not assigned to anyone.
      * @return
      *   - Return an available number. Return -1 if none is available.
      */
    def get(): Int = {
      if (unused.isEmpty) -1
      else {
        val next = unused.head
        unused -= next
        next
      }
    }

    /** Check if a number is available or not. */
    def check(number: Int): Boolean = {
      unused(number)
    }

    /** Recycle or release a number. */
    def release(number: Int) {
      unused += number
    }

  }

  /** Your PhoneDirectory object will be instantiated and called as such: var
    * obj = new PhoneDirectory(maxNumbers) var param_1 = obj.get() var param_2 =
    * obj.check(number) obj.release(number)
    */
}
