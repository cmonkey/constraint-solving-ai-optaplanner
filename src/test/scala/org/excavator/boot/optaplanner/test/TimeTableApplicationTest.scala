package org.excavator.boot.optaplanner.test

import java.time.{DayOfWeek, LocalTime}
import java.util

import javax.annotation.Resource
import org.excavator.boot.optaplanner.controller.TimeTableController
import org.excavator.boot.optaplanner.domain.{Lesson, Room, TimeTable, Timeslot}
import org.junit.jupiter.api.Assertions.{assertFalse, assertNotNull, assertTrue}
import org.junit.jupiter.api.{Test, Timeout}
import org.springframework.boot.test.context.SpringBootTest

import scala.jdk.CollectionConverters.CollectionHasAsScala

@SpringBootTest(properties = Array("optaplanner.solver.termination.spent-limit=1h",
"optaplanner.solver.termination.best-score-limit=0hard/*soft"))
class TimeTableApplicationTest {

  @Resource
  private val timeTableController: TimeTableController = null

  def generateProblem() = {

    val timesolotList = new util.ArrayList[Timeslot]()

    timesolotList.add(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(8, 30), LocalTime.of(9,30)))
    timesolotList.add(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(9, 30), LocalTime.of(10,30)))
    timesolotList.add(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(10, 30), LocalTime.of(11,30)))
    timesolotList.add(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(13, 30), LocalTime.of(14,30)))
    timesolotList.add(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(14, 30), LocalTime.of(15,30)))

    val roomList = new util.ArrayList[Room]()

    roomList.add(new Room("Room A"))
    roomList.add(new Room("Room B"))
    roomList.add(new Room("Room C"))

    val lessonList = new util.ArrayList[Lesson]()

    lessonList.add(new Lesson(101L, "Math", "B. May", "9th grade"))
    import org.excavator.boot.optaplanner.domain.Lesson
    lessonList.add(new Lesson(102L, "Physics", "M. Curie", "9th grade"))
    lessonList.add(new Lesson(103L, "Geography", "M. Polo", "9th grade"))
    lessonList.add(new Lesson(104L, "English", "I. Jones", "9th grade"))
    lessonList.add(new Lesson(105L, "Spanish", "P. Cruz", "9th grade"))

    lessonList.add(new Lesson(201L, "Math", "B. May", "10th grade"))
    lessonList.add(new Lesson(202L, "Chemistry", "M. Curie", "10th grade"))
    lessonList.add(new Lesson(203L, "History", "I. Jones", "10th grade"))
    lessonList.add(new Lesson(204L, "English", "P. Cruz", "10th grade"))
    lessonList.add(new Lesson(205L, "French", "M. Curie", "10th grade"))

    new TimeTable(timesolotList, roomList, lessonList)
  }

  @Test
  @Timeout(600_000)
  def solve(): Unit = {
    val problem = generateProblem()

    val solution = timeTableController.solve(problem)

    assertFalse(solution.getLessonList.isEmpty)

    for(lesson <- solution.getLessonList.asScala){
      assertNotNull(lesson.getTimeslot)
      assertNotNull(lesson.getRoom)
    }

    assertTrue(solution.getScore.isFeasible)
  }

}
