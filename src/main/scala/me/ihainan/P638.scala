package me.ihainan

object P638 {
  def shoppingOffers(
      price: List[Int],
      special: List[List[Int]],
      needs: List[Int]
  ): Int = {
    val memo = collection.mutable.Map.empty[List[Int], Int]
    memo(price.indices.map(_ => 0).toList) = 0

    def dfs(needs: List[Int]): Int = {
      if (memo.isDefinedAt(needs)) memo(needs)
      else {
        var min = needs.indices.map(i => needs(i) * price(i)).sum
        special.foreach { s =>
          var rest = needs.indices.map(i => needs(i) - s(i)).toList
          var mul = 1
          while (rest.forall(_ >= 0)) {
            min = min.min(dfs(rest) + s.last * mul)
            mul += 1
            rest = rest.indices.map(i => rest(i) - s(i)).toList
          }
        }
        memo(needs) = min
        memo(needs)
      }
    }

    dfs(needs)
  }
}
