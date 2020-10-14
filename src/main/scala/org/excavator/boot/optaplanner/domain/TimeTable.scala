package org.excavator.boot.optaplanner.domain

import org.optaplanner.core.api.domain.solution.{PlanningEntityCollectionProperty, PlanningScore, PlanningSolution, ProblemFactCollectionProperty}
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore

import scala.beans.BeanProperty
@PlanningSolution
case class TimeTable(
  @ValueRangeProvider(id = "timeslotRange")
  @ProblemFactCollectionProperty
  @BeanProperty
  var timeslotList:List[Timeslot],

  @ValueRangeProvider(id = "roomRange")
  @ProblemFactCollectionProperty
  @BeanProperty
  var roomList: List[Room],

  @PlanningEntityCollectionProperty
  @BeanProperty
  var lessonList:List[Lesson],

  @PlanningScore
  @BeanProperty
  var score: HardSoftScore
)

