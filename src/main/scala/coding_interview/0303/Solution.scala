import collection.mutable.{ArrayBuffer, Stack}

class StackOfPlates(_cap: Int) {
  val cap = _cap
  val stacks = collection.mutable.ArrayBuffer.empty[Stack[Int]]

  def push(x: Int) {
    if (cap > 0) {
      // val s = stacks.collectFirst { case s if s.size < cap => s }.getOrElse(null)
      // if (s != null) s.push(x)
      // else stacks += Stack(x)
      if (stacks.isEmpty || stacks.last.size == cap) stacks += Stack.empty[Int]
      stacks.last.push(x)
    }
  }

  def pop(): Int = {
    if (stacks.isEmpty || cap <= 0) -1
    else {
      val x = stacks.last.pop
      if (stacks.last.isEmpty) stacks.remove(stacks.length - 1)
      x
    }
  }

  def popAt(index: Int): Int = {
    if (index >= stacks.length || index < 0 || cap <= 0) -1
    else {
      val x = stacks(index).pop
      if (stacks(index).isEmpty) stacks.remove(index)
      x
    }
  }

}

/**
 * Your StackOfPlates object will be instantiated and called as such:
 * var obj = new StackOfPlates(cap)
 * obj.push(`val`)
 * var param_2 = obj.pop()
 * var param_3 = obj.popAt(index)
 */
