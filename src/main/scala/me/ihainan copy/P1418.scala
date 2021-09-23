package me.ihainan

object P1418 {

  import collection._

  def displayTable(orders: List[List[String]]): List[List[String]] = {
    val foods = orders.map(_.apply(2)).toSet.toArray.sorted
    val foodMap = foods.zipWithIndex.toMap
    val tableMap = mutable.Map.empty[Int, Array[Int]]
    orders.foreach { case List(_, no, food) =>
      if (!tableMap.isDefinedAt(no.toInt)) tableMap(no.toInt) = new Array[Int](foods.length)
      tableMap(no.toInt)(foodMap(food)) += 1
    }
    val sorted = tableMap.toArray.sortBy(_._1)
    val ans = mutable.ListBuffer("Table" :: foods.toList)
    sorted.foreach { order => ans += (order._1.toString :: order._2.map(_.toString).toList) }
    ans.toList
  }
}