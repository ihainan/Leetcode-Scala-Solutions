package me.ihainan

object P496Solution2 {
  def nextGreaterElement(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    val map = nums2.zipWithIndex.toMap
    val stack = collection.mutable.Stack.empty[Int]
    val nextLarger = new Array[Int](nums2.length)
    nextLarger.indices.reverse.foreach { i =>
      while (stack.nonEmpty && nums2(stack.top) < nums2(i)) { stack.pop }
      if (stack.nonEmpty) nextLarger(i) = nums2(stack.top)
      else nextLarger(i) = -1
      stack.push(i)
    }
    nums1.map(num => nextLarger(map(num)))
  }
}
