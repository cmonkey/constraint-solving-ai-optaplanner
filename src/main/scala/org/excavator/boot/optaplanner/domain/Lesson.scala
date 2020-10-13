package org.excavator.boot.optaplanner.domain

import org.optaplanner.core.api.domain.entity.PlanningEntity
import org.optaplanner.core.api.domain.variable.PlanningVariable

import scala.beans.BeanProperty

@PlanningEntity
case class Lesson(@BeanProperty id:Long,
            @BeanProperty subject:String,
            @BeanProperty teacher:String,
            @BeanProperty studentGroup:String){

  @PlanningVariable(valueRangeProviderRefs = Array("roomRange"))
  @BeanProperty
  var timeslot:Timeslot = null

  @PlanningVariable(valueRangeProviderRefs = Array("roomRange"))
  @BeanProperty
  var room:Room = null
}
