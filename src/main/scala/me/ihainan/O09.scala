package me.ihainan

object O09 {

  class CQueue() {

    import collection.mutable.Stack

    val s1 = Stack.empty[Int]
    val s2 = Stack.empty[Int]

    def appendTail(value: Int) {
      s1.push(value)
    }

    def deleteHead(): Int = {
      if (s2.isEmpty && s1.isEmpty) -1
      else {
        if (s2.isEmpty) {
          while (s1.nonEmpty) s2.push(s1.pop)
        }
        s2.pop
      }
    }
  }

  /**
    * Your CQueue object will be instantiated and called as such:
    * var obj = new CQueue()
    * obj.appendTail(value)
    * var param_2 = obj.deleteHead()
    */
}