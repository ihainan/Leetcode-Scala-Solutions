package me.ihainan

object R1606 {

  import util.Sorting.quickSort

  def smallestDifference(a: Array[Int], b: Array[Int]): Int = {
    quickSort(a)
    quickSort(b)
    var (i, j, min) = (0, 0, Int.MaxValue)
    while (i < a.length && j < b.length) {
      val diff = (a(i).toLong - b(j).toLong).abs
      if (diff < Int.MaxValue) min = min.min(diff.toInt)
      if (a(i) == b(j)) return 0
      else if (a(i) > b(j)) j += 1
      else i += 1
    }
    min
  }
}