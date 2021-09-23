package me.ihainan

object P218 {

  import collection.mutable.{ArrayBuffer, ListBuffer}

  def getSkyline(buildings: Array[Array[Int]]): List[List[Int]] = {
    case class Box(s: Int, e: Int, h: Int)

    val bs = buildings.map { b => Box(b(0), b(1), b(2)) }
    val boxes = ArrayBuffer.empty[Box]

    bs.foreach { b =>
      if (boxes.isEmpty || b.s >= boxes.last.e) boxes += b
      else {
        val start =
          (boxes.length - 1 to 0 by -1).collectFirst { case i if boxes(i).s <= b.s => i }.get
        var i = start
        val toAdd = ArrayBuffer.empty[Box]
        while (i < boxes.length && b.e >= boxes(i).s) {
          val box = boxes(i)
          if (i != start && box.s > boxes(i - 1).e) toAdd += Box(boxes(i - 1).e, box.s, b.h)
          if (b.h > box.h) {
            toAdd ++= Array(
              Box(box.s, b.s, box.h),
              Box(b.s.max(box.s), b.e.min(box.e), b.h),
              Box(b.e, box.e, box.h)
            ).filter(box => box.s < box.e)
          } else toAdd += box
          i += 1
        }
        if (b.e > boxes.last.e) toAdd += Box(boxes.last.e, b.e, b.h)
        boxes.remove(start, i - start)
        toAdd.indices.reverse.foreach { i => boxes.insert(start, toAdd(i)) }
      }
    }

    val ans = ListBuffer.empty[List[Int]]
    (0 until boxes.length).foreach { i =>
      val box = boxes(i)
      val prev = if (i == 0) Box(0, box.s, 0) else boxes(i - 1)
      if (box.s != prev.e) ans += List(prev.e, 0)
      if (box.h != prev.h) ans += List(box.s, box.h)
    }
    ans += List(boxes.last.e, 0)

    ans.toList
  }
}