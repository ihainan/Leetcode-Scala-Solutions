package me.ihainan

object P1086 {

  import collection.JavaConverters._
  import java.util.TreeMap
  import collection.mutable.PriorityQueue

  def highFive(items: Array[Array[Int]]): Array[Array[Int]] = {
    val map = new TreeMap[Int, PriorityQueue[Int]]().asScala

    items.foreach { item =>
      if (!map.isDefinedAt(item(0))) map(item(0)) = PriorityQueue.empty[Int]
      map(item(0)).enqueue(item(1))
    }

    map.map { case (k, v) =>
      Array(k, (0 until 5).map(_ => v.dequeue).sum / 5)
    }.toArray
  }
}