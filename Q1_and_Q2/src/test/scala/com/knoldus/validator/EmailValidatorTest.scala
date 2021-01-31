package com.knoldus.validator

import com.knoldus.models.Email
import com.knoldus.validators.EmailValidator
import org.scalatest.flatspec.AnyFlatSpec

class EmailValidatorTest extends AnyFlatSpec{

  val emailValidator:EmailValidator=new EmailValidator()

  "This Email" should "be valid as it is written in correct format" in{

    val email:Email=new Email("rex@gmail.com")
    assert(emailValidator.isEmailValid(email))
  }

  it should "not valid as it contains blank space" in{

    val email:Email=new Email("rex taylor@gmail.com")
    assert(!emailValidator.isEmailValid(email))
  }

  it should "not valid as it contains more than one dot symbol" in{

    val email:Email=new Email("rex@gmail..com")
    assert(!emailValidator.isEmailValid(email))
  }

  it should "not valid as it does not contain @ symbol" in{

    val email:Email=new Email("rexgmail.com")
    assert(!emailValidator.isEmailValid(email))
  }
}
