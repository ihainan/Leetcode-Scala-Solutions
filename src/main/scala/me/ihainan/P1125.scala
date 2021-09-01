package me.ihainan

object P1125 {
  def smallestSufficientTeam(req_skills: Array[String], people: List[List[String]]): Array[Int] = {
    val skills = people.flatten.distinct
    val skillToID = skills.zipWithIndex.toMap
    val pplToSkillMask = people.map { skill => skill.map(s => 1 << skillToID(s)).sum }
    val reqSkillMask = req_skills.map(s => 1 << skillToID(s)).sum
    val n = skills.length
    val maxNum = 1 << n
    val dp = Array.fill[List[Int]](maxNum)(null)
    dp(0) = Nil

    people.indices.foreach { i =>
      val mask = pplToSkillMask(i)
      (maxNum - 1 to mask by -1).foreach { v =>
        // get all submask
        var subset = mask
        while (subset != 0) {
          val restMask = v - subset
          if ((subset & v) == subset && dp(restMask) != null) {
            if (dp(v) == null || dp(v).size > dp(restMask).size + 1) {
              dp(v) = dp(restMask) :+ i
            }
          }
          subset = (subset - 1) & mask
        }
      }
    }

    dp(reqSkillMask).toArray
  }
}