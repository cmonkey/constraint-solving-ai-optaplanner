package org.excavator.boot.optaplanner.calculator

import org.excavator.boot.optaplanner.domain.TimeTable
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore
import org.optaplanner.core.impl.score.director.easy.EasyScoreCalculator

class TimeTableEasyScoreCalculator extends EasyScoreCalculator[TimeTable] {
  override def calculateScore(timeTable: TimeTable): HardSoftScore = {

    val lessonList = timeTable.getLessonList

    var hardScore = 0

    for (a <- lessonList){
      for (b <- lessonList){
        if(a.getTimeslot != null && a.getTimeslot.equals(b.getTimeslot) && a.getId < b.getId){
          if (a.getRoom != null && a.getRoom.equals(b.getRoom)){
            hardScore += 1
          }

          if(a.getTeacher.equals(b.getTeacher)){
            hardScore -= 1
          }

          if(a.getStudentGroup.equals(b.getStudentGroup)){
            hardScore -= 1
          }
        }

      }
    }

    val softScore = 0

    HardSoftScore.of(hardScore, softScore)

  }
}
