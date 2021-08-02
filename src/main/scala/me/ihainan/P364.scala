package me.ihainan

object P364 {
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

  /**
    * // This is the interface that allows for creating nested lists.
    * // You should not implement it, or speculate about its implementation
    * trait NestedInteger {
    *
    *   // Return true if this NestedInteger holds a single integer, rather than a nested list.
    *   def isInteger: Boolean
    *
    *   // Return the single integer that this NestedInteger holds, if it holds a single integer.
    *   def getInteger: Int
    *
    *   // Set this NestedInteger to hold a single integer.
    *   def setInteger(i: Int): Unit
    *
    *   // Return the nested list that this NestedInteger holds, if it holds a nested list.
    *   def getList: Array[NestedInteger]
    *
    *   // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    *   def add(ni: NestedInteger): Unit
    * }
    */
  def depthSumInverse(nestedList: List[NestedInteger]): Int = {
    def maxDepth(list: List[NestedInteger]): Int = {
      if (list.isEmpty) 0
      else list.map { e => if (e.isInteger) 1 else maxDepth(e.getList.toList) }.max + 1
    }

    val maxDep = maxDepth(nestedList)

    def sum(list: List[NestedInteger], depth: Int): Int = {
      list.map {
        case e if e.isInteger => e.getInteger * (maxDep - depth)
        case e => sum(e.getList.toList, depth + 1)
      }.sum
    }

    sum(nestedList, 1)
  }
}