package me.ihainan

object P752 {
  def openLock(deadends: Array[String], target: String): Int = {
    val deadSet = deadends.toSet

    if (deadSet("0000")) -1
    else {
      val visited = collection.mutable.Set("0000")
      val queue = collection.mutable.Queue("0000")
      var depth = -1
      while (queue.nonEmpty) {
        depth += 1
        val nodes = queue.indices.map(_ => queue.dequeue)
        if (nodes.contains(target)) return depth
        else {
          nodes.foreach { node =>
            val chars = node.toCharArray
            (0 until 4).foreach { i =>
              val c = chars(i)
              if (c == '9') chars(i) = '0' else chars(i) = (c + 1).toChar
              val plusOne = new String(chars)
              if (c == '0') chars(i) = '9' else chars(i) = (c - 1).toChar
              val subOne = new String(chars)
              chars(i) = c
              if (!deadSet(plusOne) && !visited(plusOne)) {
                visited += plusOne
                queue.enqueue(plusOne)
              }
              if (!deadSet(subOne) && !visited(subOne)) {
                visited += subOne
                queue.enqueue(subOne)
              }
            }
          }
        }
      }
      -1
    }
  }
}