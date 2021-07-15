package me.ihainan

object P733 {
  def floodFill(image: Array[Array[Int]], sr: Int, sc: Int, newColor: Int): Array[Array[Int]] = {
    val queue = collection.mutable.Queue((sr, sc))
    val set = collection.mutable.Set((sr, sc))
    val mx = Array(0, 1, 0, -1)
    val my = Array(1, 0, -1, 0)
    val color = image(sr)(sc)
    while (queue.nonEmpty) {
      val nodes = queue.indices.map(_ => queue.dequeue)
      nodes.foreach { case (x, y) =>
        image(x)(y) = newColor
        (0 until 4).foreach { i =>
          val nx = x + mx(i)
          val ny = y + my(i)
          if (nx >= 0 && nx < image.length && ny >= 0 && ny < image.head.length && !set((nx, ny)) && image(nx)(ny) == color) {
            set += ((nx, ny))
            queue.enqueue((nx, ny))
          }
        }
      }
    }
    image
  }
}