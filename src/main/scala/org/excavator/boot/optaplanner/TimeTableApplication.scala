package org.excavator.boot.optaplanner

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class TimeTableApplication{
}

object TimeTableApplication{
  def main(args:Array[String]):Unit = {
    SpringApplication.run(classOf[TimeTableApplication], args:_*)
  }
}
