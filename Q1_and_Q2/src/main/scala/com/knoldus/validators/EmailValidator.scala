package com.knoldus.validators

import com.knoldus.models.Email

import java.util.regex._

class EmailValidator {
  val emailRegex: String = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
  val pattern: Pattern =Pattern.compile(emailRegex)


  // this method returns true if given email is valid else false
  def isEmailValid(email: Email): Boolean = {
    val matcher:Matcher = pattern.matcher(email.emailAddress)
    matcher.matches
  }
}