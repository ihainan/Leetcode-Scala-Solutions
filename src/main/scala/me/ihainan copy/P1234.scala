package me.ihainan

object P1234 {
  def transformArray(arr: Array[Int]): List[Int] = {
    while (true) {
      var ops = 0
      val newArr = arr.map(x => x)
      (1 until arr.length - 1).foreach { i =>
        if (arr(i) < arr(i - 1) && arr(i) < arr(i + 1)) {
          newArr(i) = arr(i) + 1
          ops += 1
        } else if (arr(i) > arr(i - 1) && arr(i) > arr(i + 1)) {
          newArr(i) = arr(i) - 1
          ops += 1
        }
      }
      if (ops == 0) return arr.toList
      else arr.indices.foreach { i => arr(i) = newArr(i) }
    }

    Nil
  }
}