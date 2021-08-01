package me.ihainan

object P353 {
  class SnakeGame(_width: Int, _height: Int, _food: Array[Array[Int]]) {
    /** Initialize your data structure here.
      *
      * @param width  - screen width
      * @param height - screen height
      * @param food   - A list of food positions
      *               E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    val path = new java.util.LinkedList[(Int, Int)]()
    val set = collection.mutable.Set((0, 0))
    path.addFirst((0, 0))
    var currentFood = 0
    val mx = Array(0, 1, 0, -1)
    val my = Array(1, 0, -1, 0)
    val map = Array("R", "D", "L", "U").zipWithIndex.toMap

    /** Moves the snake.
      *
      * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
      * @return The game's score after the move. Return -1 if game over.
      *         Game over when snake crosses the screen boundary or bites its body. */
    def move(direction: String): Int = {
      val i = map(direction)
      val (cx, cy) = path.getFirst
      val (nx, ny) = (cx + mx(i), cy + my(i))
      val (lx, ly) = path.getLast

      if (nx < 0 || ny < 0 || nx >= _height || ny >= _width) return -1
      if (currentFood != _food.length && nx == _food(currentFood)(0) && ny == _food(currentFood)(1)) {
        currentFood += 1
      } else {
        set -= ((lx, ly))
        path.removeLast()
      }

      if (set((nx, ny))) return -1
      path.addFirst((nx, ny))
      set += ((nx, ny))
      path.size - 1
    }

  }

  /**
    * Your SnakeGame object will be instantiated and called as such:
    * var obj = new SnakeGame(width, height, food)
    * var param_1 = obj.move(direction)
    */
}