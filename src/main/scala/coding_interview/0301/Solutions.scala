class TripleInOne(_stackSize: Int) {
  val stackSize = _stackSize
  val data = new Array[Int](stackSize * 3)
  val starts = Array(0, stackSize, stackSize * 2)
  val ends = Array(stackSize - 1, stackSize * 2 - 1, stackSize * 3 - 1)
  val nexts = Array(0, stackSize, stackSize * 2)

  def push(stackNum: Int, value: Int) {
    if (stackNum < 3 && nexts(stackNum) <= ends(stackNum)) {
      data(nexts(stackNum)) = value
      nexts(stackNum) += 1 
    }
  }

  def pop(stackNum: Int): Int = {
    if (stackNum >= 3) -1
    else if (nexts(stackNum) == starts(stackNum)) -1 
    else {
      nexts(stackNum) -= 1
      data(nexts(stackNum))
    }
  }

  def peek(stackNum: Int): Int = {
    if (stackNum >= 3) -1
    else if (nexts(stackNum) == starts(stackNum)) -1
    else data(nexts(stackNum) - 1)
  }

  def isEmpty(stackNum: Int): Boolean = {
    if (stackNum >= 3) true
    else nexts(stackNum) == starts(stackNum)
  }

}

/**
 * Your TripleInOne object will be instantiated and called as such:
 * var obj = new TripleInOne(stackSize)
 * obj.push(stackNum,value)
 * var param_2 = obj.pop(stackNum)
 * var param_3 = obj.peek(stackNum)
 * var param_4 = obj.isEmpty(stackNum)
 */
