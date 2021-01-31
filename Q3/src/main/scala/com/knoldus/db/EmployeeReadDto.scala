package com.knoldus.db

import com.knoldus.models.Employee

import scala.collection.immutable.HashMap

class EmployeeReadDto {

  val aEmployee: Employee = Employee("Rex","Taylor",33,15000,"Intern","Google","rex@gmail.com")
  val bEmployee: Employee = Employee("Sam","Raimi",33,15000,"Intern","Google","sam@gmail.com")
  val employees: HashMap[String, Employee] = HashMap("Rex" -> aEmployee, "Sam" -> bEmployee)

  def getEmployeeByName(name: String): Option[Employee] = employees.get(name)

}
