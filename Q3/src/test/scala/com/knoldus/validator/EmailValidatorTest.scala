package com.knoldus.validator
import org.scalatest.flatspec.AnyFlatSpec

class EmailValidatorTest extends AnyFlatSpec {

  "email" should "be invalid as it does not contain recipient name" in {
    val emailValidator = new EmailValidator
    assert(!emailValidator.emailIdIsValid("@gmail.com"))
  }

  "email" should "not be valid as @ symbol missing" in {
    val emailValidator = new EmailValidator
    assert(!emailValidator.emailIdIsValid("rexgmail.com"))
  }

  "email" should "not be valid as domain name missing" in {
    val emailValidator = new EmailValidator
    assert(!emailValidator.emailIdIsValid("rex@.com"))
  }

  "email" should "not be valid as it does not contain top level domain" in {
    val emailValidator = new EmailValidator
    assert(!emailValidator.emailIdIsValid("rex@gmail"))
  }

  "email" should "be valid" in {
    val emailValidator = new EmailValidator
    assert(emailValidator.emailIdIsValid("rex@gmail.com"))
  }
}
