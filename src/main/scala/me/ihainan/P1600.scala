package me.ihainan

object P1600 {
  import collection.mutable._

  class ThroneInheritance(_kingName: String) {

    case class Person(name: String) {
      val children: ListBuffer[Person] = ListBuffer.empty[Person]
    }

    val king = Person(_kingName)
    val map = Map(_kingName -> king)
    val deads = Set.empty[String]

    def birth(parentName: String, childName: String) {
      val parent = map(parentName)
      val child = Person(childName)
      map(childName) = child
      parent.children += child
    }

    def death(name: String): Unit = deads += name

    def getInheritanceOrder(): List[String] = {
      val list = ListBuffer.empty[Person]

      def visit(p: Person): Unit = {
        list += p
        p.children.foreach { c => visit(c) }
      }

      visit(king)
      list.filter(c => !deads(c.name)).map(_.name).toList
    }
  }

  /** Your ThroneInheritance object will be instantiated and called as such:
    * var obj = new ThroneInheritance(kingName)
    * obj.birth(parentName,childName)
    * obj.death(name)
    * var param_3 = obj.getInheritanceOrder()
    */
}
