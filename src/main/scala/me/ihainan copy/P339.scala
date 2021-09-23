package me.ihainan

object P339 {

  trait NestedInteger {

    // Return true if this NestedInteger holds a single integer, rather than a nested list.
    def isInteger: Boolean

    // Return the single integer that this NestedInteger holds, if it holds a single integer.
    def getInteger: Int

    // Set this NestedInteger to hold a single integer.
    def setInteger(i: Int): Unit

    // Return the nested list that this NestedInteger holds, if it holds a nested list.
    def getList: Array[NestedInteger]

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    def add(ni: NestedInteger): Unit
  }
  
  def depthSum(nestedList: List[NestedInteger]): Int = {

    def helper(list: List[NestedInteger], depth: Int): Int = {
      list.map { elem =>
        if (elem.isInteger) depth * elem.getInteger
        else helper(elem.getList.toList, depth + 1)
      }.sum
    }

    helper(nestedList, 1)
  }
}