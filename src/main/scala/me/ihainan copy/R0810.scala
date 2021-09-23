package me.ihainan

object R0810 {
  val mx = Array(0, 0, 1, -1)
  val my = Array(1, -1, 0, 0)

  def floodFill(image: Array[Array[Int]], sr: Int, sc: Int, newColor: Int): Array[Array[Int]] = {
    // Notice that the color at point(sr)(sc) may be newColor
    if (image.length > 0 && image.head.length > 0 && image(sr)(sc) != newColor) {
      dfs(image, sr, sc, image.length, image.head.length, image(sr)(sc), newColor)
    }
    image
  }

  def dfs(image: Array[Array[Int]], x: Int, y: Int, m: Int, n: Int, oldColor: Int, newColor: Int): Unit = {
    if (x >= 0 && x < m && y >= 0 && y < n && image(x)(y) == oldColor) {
      image(x)(y) = newColor
      (0 until 4).foreach { i =>
        dfs(image, x + mx(i), y + my(i), m, n, oldColor, newColor)
      }
    }
  }
}