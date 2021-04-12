package me.ihainan

object O09 {

  class CQueue() {
    val s1 = collection.mutable.Stack.empty[Int]
    val s2 = collection.mutable.Stack.empty[Int]

    def appendTail(value: Int) {
      s1.push(value)
    }

    def deleteHead(): Int = {
      if (s2.isEmpty) {
        while (s1.nonEmpty) s2.push(s1.pop)
      }
      if (s2.isEmpty) -1
      else s2.pop
    }
  }

  /**
    * Your CQueue object will be instantiated and called as such:
    * var obj = new CQueue()
    * obj.appendTail(value)
    * var param_2 = obj.deleteHead()
    */
}