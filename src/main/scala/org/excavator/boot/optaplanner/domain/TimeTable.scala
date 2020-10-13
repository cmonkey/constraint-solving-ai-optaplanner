package org.excavator.boot.optaplanner.domain

import org.optaplanner.core.api.domain.solution.{PlanningEntityCollectionProperty, PlanningScore, ProblemFactCollectionProperty}
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore

case class TimeTable(
  @ValueRangeProvider(id = "timeslotRange")
  @ProblemFactCollectionProperty
  var timeslotList:List[Timeslot],

  @ValueRangeProvider(id = "roomRange")
  @ProblemFactCollectionProperty
  var roomList: List[Room],

  @PlanningEntityCollectionProperty
  lessonList:List[Lesson],

  @PlanningScore
  var score: HardSoftScore
)

