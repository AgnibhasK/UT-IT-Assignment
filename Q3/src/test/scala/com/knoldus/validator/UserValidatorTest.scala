package com.knoldus.validator

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.{Company, User}
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.flatspec.AnyFlatSpec

class UserValidatorTest extends AnyFlatSpec {

  val aUser: User = User("Rex","Taylor",33,"Google","rex@gmail.com")
  val aCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")

  val mockedCompanyReadDto = mock[CompanyReadDto]
  val mockedEmailvalidator = mock[EmailValidator]

  val userValidator = new UserValidator(mockedCompanyReadDto,mockedEmailvalidator)

  "User" should "be valid as email format correct and company exists in DB" in {

    when(mockedCompanyReadDto.getCompanyByName(aUser.companyName)) thenReturn(Option(aCompany))
    when(mockedEmailvalidator.emailIdIsValid(aUser.emailId)) thenReturn(true)

    val result = userValidator.userIsValid(aUser)
    assert(result)
  }

  "User" should "not be valid as his email is not valid" in {

    when(mockedCompanyReadDto.getCompanyByName(aUser.companyName)) thenReturn(Option(aCompany))
    when(mockedEmailvalidator.emailIdIsValid(aUser.emailId)) thenReturn(false)

    val result = userValidator.userIsValid(aUser)
    assert(!result)
  }

  "User" should "not be valid as his company does not exists in DB" in {

    when(mockedCompanyReadDto.getCompanyByName(aUser.companyName)) thenReturn(None)
    when(mockedEmailvalidator.emailIdIsValid(aUser.emailId)) thenReturn(true)

    val result = userValidator.userIsValid(aUser)
    assert(!result)
  }

  "User" should "not be valid as his email id is not valid and his company does not exists in DB" in {

    when(mockedCompanyReadDto.getCompanyByName(aUser.companyName)) thenReturn(None)
    when(mockedEmailvalidator.emailIdIsValid(aUser.emailId)) thenReturn(false)

    val result = userValidator.userIsValid(aUser)
    assert(!result)
  }

}
