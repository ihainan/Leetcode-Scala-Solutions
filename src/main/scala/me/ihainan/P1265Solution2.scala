package me.ihainan

object P1265Solution2 {

  class ImmutableListNode {
    def printValue(): Unit = {} // print the value of this node.

    def getNext(): ImmutableListNode = null
  }

  def printLinkedListInReverse(head: ImmutableListNode): Unit = {
      if (head != null) {
        var fastBegin = head.getNext
        while (fastBegin != null) {
          var (slow, fast) = (head, fastBegin)
          while (fast != null) {
            fast = fast.getNext
            slow = slow.getNext
          }
          slow.printValue()
          fastBegin = fastBegin.getNext
        }
        head.printValue
      }
    }
  }