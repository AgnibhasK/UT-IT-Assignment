package com.knoldus.request

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.User
import com.knoldus.validator.{EmailValidator, UserValidator}
import org.scalatest.flatspec.AnyFlatSpec

class UserImplIntegrationTest extends AnyFlatSpec {

  val companyName = new CompanyReadDto
  val validateEmail = new EmailValidator
  val userValidator = new UserValidator(companyName,validateEmail)

  val userImpl = new UserImpl(userValidator)

  "User" should "not be created as company does not exists in DB" in {
    val firstlUser: User = User("First","User",33,"Google","first@gmail.com")

    val result = userImpl.createUser(firstlUser)
    assert(result.isEmpty)
  }

  "User" should "not be created as email id is not valid" in {
    val secondUser: User = User("Second","User",33,"Google","second@gmail.com")

    val result = userImpl.createUser(secondUser)
    assert(result.isEmpty)
  }

  "User" should "not be created as company does not exists in DB and email id is not valid" in {
    val thirdUser: User = User("Third","User",33,"Google","third@gmail.com")

    val result = userImpl.createUser(thirdUser)
    assert(result.isEmpty)
  }

  "User" should "be created" in {
    val fourthUser: User = User("Fourth","User",33,"Google","fourth@gmail.com")

    val result = userImpl.createUser(fourthUser)
    assert(!result.isEmpty)
  }

}
