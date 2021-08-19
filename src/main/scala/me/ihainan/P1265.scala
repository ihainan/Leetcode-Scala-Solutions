package me.ihainan

object P1265 {

  class ImmutableListNode {
    def printValue(): Unit = {} // print the value of this node.

    def getNext(): ImmutableListNode = null
  }

  def printLinkedListInReverse(head: ImmutableListNode): Unit = {
    if (head != null) {
      printLinkedListInReverse(head.getNext())
      head.printValue()
    }
  }
}