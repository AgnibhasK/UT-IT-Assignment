package com.knoldus.validator

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.Company
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.flatspec.AnyFlatSpec

class CompanyValidatorTest extends AnyFlatSpec {

  val aCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")

  val mockedCompanyReadDto = mock[CompanyReadDto]
  val mockedEmailvalidator = mock[EmailValidator]

  val companyValidator = new CompanyValidator(mockedCompanyReadDto,mockedEmailvalidator)

  "Company" should "be valid as email format correct company not in DB" in {

    when(mockedCompanyReadDto.getCompanyByName(aCompany.name)) thenReturn(None)
    when(mockedEmailvalidator.emailIdIsValid(aCompany.emailId)) thenReturn(true)

    val result = companyValidator.companyIsValid(aCompany)
    assert(result)
  }

  "Company" should "not be valid as it already exists in the DB" in {

    when(mockedCompanyReadDto.getCompanyByName(aCompany.name)) thenReturn(Option(aCompany))
    when(mockedEmailvalidator.emailIdIsValid(aCompany.emailId)) thenReturn(true)

    val result = companyValidator.companyIsValid(aCompany)
    assert(!result)
  }

  "Company" should "not be valid as the email id not valid" in {

    when(mockedCompanyReadDto.getCompanyByName(aCompany.name)) thenReturn(None)
    when(mockedEmailvalidator.emailIdIsValid(aCompany.emailId)) thenReturn(false)

    val result = companyValidator.companyIsValid(aCompany)
    assert(!result)
  }

  "Company" should "not be valid as email id not valid and company exists in the DB" in {

    when(mockedCompanyReadDto.getCompanyByName(aCompany.name)) thenReturn(Option(aCompany))
    when(mockedEmailvalidator.emailIdIsValid(aCompany.emailId)) thenReturn(false)

    val result = companyValidator.companyIsValid(aCompany)
    assert(!result)
  }

}
