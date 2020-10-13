package org.excavator.boot.optaplanner.calculator

import org.excavator.boot.optaplanner.domain.TimeTable
import org.optaplanner.core.api.score.Score
import org.optaplanner.core.impl.score.director.easy.EasyScoreCalculator

class TimeTableEasyScoreCalculator extends EasyScoreCalculator[TimeTable] {
  override def calculateScore(solution: TimeTable): Score[_ <: Score[_ <: AnyRef]] = {

  }
}
