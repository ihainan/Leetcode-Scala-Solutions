package me.ihainan

import scala.collection.mutable.Map

object R1726 {
  def calculate(docA: Array[Int], docB: Array[Int]): Double = {
    var (i, j, common) = (0, 0, 0)
    while (i < docA.length || j < docB.length) {
      if (i == docA.length) {
        j += 1
      } else if (j == docB.length) {
        i += 1
      } else if (docA(i) == docB(j)) {
        common += 1
        i += 1
        j += 1
      } else {
        if (docA(i) < docB(j)) i += 1
        else j += 1
      }
    }

    if (common == 0) 0
    else common * 1.0 / (docA.length + docB.length - common)
  }

  def computeSimilarities(docs: Array[Array[Int]]): List[String] = {
    val sorted = docs.map(_.sorted)
    val ans = collection.mutable.ListBuffer.empty[String]
    (0 until sorted.length - 1).foreach { i =>
      (i + 1 until sorted.length).foreach { j =>
        val similarity = calculate(sorted(i), sorted(j))
        if (similarity != 0) ans += f"$i,$j: $similarity%.4f"
      }
    }
    ans.toList
  }
}