package me.ihainan

object P1125Solution2 {
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
      (0 until maxNum).foreach { v =>
        if (dp(v) != null) {
          val newMask = v | mask
          if (dp(newMask) == null || dp(newMask).size > dp(v).size + 1) {
            dp(newMask) = dp(v) :+ i
          }
        }
      }
    }

    dp(reqSkillMask).toArray
  }
}