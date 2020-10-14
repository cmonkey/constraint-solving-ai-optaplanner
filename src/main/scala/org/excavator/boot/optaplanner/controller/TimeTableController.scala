package org.excavator.boot.optaplanner.controller

import java.util.UUID

import javax.annotation.Resource
import org.excavator.boot.optaplanner.domain.TimeTable
import org.optaplanner.core.api.solver.SolverManager
import org.springframework.web.bind.annotation.{PostMapping, RequestBody, RequestMapping, RestController}

@RestController
@RequestMapping(Array("/timeTable"))
class TimeTableController{

  @Resource
  val solverManager:SolverManager[TimeTable, UUID]  = null

  @PostMapping(Array("/solve"))
  def solve(@RequestBody problem:TimeTable) = {
    val problemId = UUID.randomUUID()

    val solverJob = solverManager.solve(problemId, problem)

    val solution:TimeTable = solverJob.getFinalBestSolution()

    solution
  }
}
