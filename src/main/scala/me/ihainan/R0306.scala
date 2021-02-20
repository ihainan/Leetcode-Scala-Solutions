package me.ihainan

// AnimalShelf
class R0306() {
  val q0 = collection.mutable.Queue.empty[Int]
  val q1 = collection.mutable.Queue.empty[Int]

  def enqueue(animal: Array[Int]) {
    if (animal(1) == 0) q0.enqueue(animal(0)) else q1.enqueue(animal(0))
  }

  def dequeueAny(): Array[Int] = {
    if (q0.isEmpty && q1.isEmpty) Array(-1, -1)
    else if (q0.isEmpty || (q1.nonEmpty && q1.head < q0.head)) Array(q1.dequeue, 1)
    else Array(q0.dequeue, 0)
  }

  def dequeueDog(): Array[Int] = {
    if (q1.isEmpty) Array(-1, -1)
    else Array(q1.dequeue, 1)
  }

  def dequeueCat(): Array[Int] = {
    if (q0.isEmpty) Array(-1, -1)
    else Array(q0.dequeue, 0)
  }

}

/**
 * Your AnimalShelf object will be instantiated and called as such:
 * var obj = new AnimalShelf()
 * obj.enqueue(animal)
 * var param_2 = obj.dequeueAny()
 * var param_3 = obj.dequeueDog()
 * var param_4 = obj.dequeueCat()
 */
