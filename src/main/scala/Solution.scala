object Solution {
  def smallestSufficientTeam(req_skills: Array[String], people: List[List[String]]): Array[Int] = {
    val skills = people.flatten.distinct
    val skill2id = skills.zipWithIndex.toMap
    val requireMask = req_skills.map(s => 1 << skill2id(s)).sum
    val ppl2skill = people.map(_.map(s => skill2id(s)).toSet)
    val skill2ppl = collection.mutable.Map.empty[Int, List[Int]].withDefaultValue(Nil)
    people.indices.foreach { i =>
      people(i).foreach { s =>
        val skillId = skill2id(s)
        skill2ppl(skillId) = skill2ppl(skillId) :+ i
      }
    }

    val n = skills.length
    val maxNum = 1 << n
    val dp = Array.fill[(Set[Int], Set[Int])](maxNum)((null, null)) // (people, skill-set)
    dp(0) = (Set.empty[Int], Set.empty[Int])

    println(skill2id.mkString(", "))
    println(requireMask.toBinaryString)
    println(ppl2skill.mkString(", "))
    println(skill2ppl.mkString(", "))

    (1 until maxNum).foreach { mask =>
      (0 until n).foreach { i => // skill to learn
        if (((1 << i) & mask) != 0) {
          val submask = (1 << i) ^ mask
          var (subPpl, subSkill) = dp(submask)

          if (!subSkill(i)) {
            // need to find a people to add this skill
            var toAddPpl = -1
            skill2ppl(i).filter(p => !subPpl(p)).foreach { p =>
              val newSubSkill = subSkill ++ ppl2skill(p)
              if (newSubSkill.size > subSkill.size) {
                subSkill = newSubSkill
                toAddPpl = p
              }
            }
            subPpl += toAddPpl
          }

          if (dp(mask)._1 == null || dp(mask)._1.size > subPpl.size || // less people or same people + more skills
            (dp(mask)._1.size == subPpl.size && dp(mask)._2.size < subSkill.size)) {
            dp(mask) = (subPpl, subSkill)
          }
        }
      }

      if (mask == requireMask) return dp(mask)._1.toArray
    }

    Array.empty[Int]
  }
}