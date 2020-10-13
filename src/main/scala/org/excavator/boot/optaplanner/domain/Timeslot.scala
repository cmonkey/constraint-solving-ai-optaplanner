package org.excavator.boot.optaplanner.domain

import java.time.{DayOfWeek, LocalTime}

case class Timeslot(dayOfWeek: DayOfWeek, startTime: LocalTime, endTime: LocalTime) {
  override def toString() = dayOfWeek + " " + startTime.toString()

}
