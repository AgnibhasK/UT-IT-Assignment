package com.knoldus.db

import com.knoldus.models.Company

import scala.collection.immutable.HashMap

class CompanyReadDto {

  val aCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")
  val bCompany: Company = Company("Google", "google@gmail", "US")
  val companies: HashMap[String, Company] = HashMap("Knoldus" -> aCompany, "Google" -> bCompany)

  def getCompanyByName(name: String): Option[Company] = companies.get(name)

}
