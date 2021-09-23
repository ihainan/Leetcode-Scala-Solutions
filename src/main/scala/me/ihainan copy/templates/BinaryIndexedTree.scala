package me.ihainan.templates

// Reference: https://blog.csdn.net/Yaokai_AssultMaster/article/details/79492190
class BinaryIndexedTree(val input: Array[Int]) {
  val n = input.length
  val arr = new Array[Int](n + 1)

  // O(N * logN) initialization
  // input.indices.foreach { i => update(i + 1, input(i)) }

  // O(N) initialization
  System.arraycopy(input, 0, arr, 1, input.length)
  (1 to n).foreach { i => val j = i + (i & -i); if (j <= n) arr(j) += arr(i) }

  // O(N * logN) initialization
  def update(i: Int, delta: Int): Unit = {
    if (i < n + 1) {
      arr(i) += delta
      update(i + (i & -i), delta)
    }
  }

  def prefixSum(i: Int): Int = {
    if (i == 0) 0
    else arr(i) + prefixSum(i - (i & -i))
  }
}

object BinaryIndexedTree extends App {
  val input = Array(1, 7, 3, 0, 5, 8, 3, 2, 6, 2, 1, 1, 4, 5)
  val bit = new BinaryIndexedTree(input)
  println(bit.arr.mkString(", "))
  println(input.indices.map(i => bit.prefixSum(i + 1)).mkString(", "))
  var sum = 0
  println(input.map { num => sum += num; sum }.mkString(", "))
}
