package me.ihainan

object P1213 {
  def arraysIntersection(arr1: Array[Int], arr2: Array[Int], arr3: Array[Int]): List[Int] = {
    var (i, j, k) = (0, 0, 0)
    val ans = collection.mutable.ListBuffer.empty[Int]

    while (i < arr1.length && j < arr2.length && k < arr3.length) {
      if (arr1(i) == arr2(j) && arr2(j) == arr3(k)) {
        ans += arr1(i)
        i += 1
        j += 1
        k += 1
      } else {
        val min = arr1(i).min(arr2(j)).min(arr3(k))
        if (arr1(i) == min) i += 1
        else if (arr2(j) == min) j += 1
        else k += 1
      }
    }

    ans.toList
  }
}