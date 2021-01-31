package com.knoldus.impl

import org.scalatest.flatspec.AnyFlatSpec

class DivideAndFibonacciImplTest extends AnyFlatSpec {

  val forValidatingDivideOpr =new DivideAndFibonacciImpl()
  val forValidatingFibonacciOpr =new DivideAndFibonacciImpl()

  //Divide unit test case

  "A number 100" should "return 25 when divided by 4" in{

    assert(forValidatingDivideOpr.divide(10,2)==5)
  }

  it should "throw ArithmeticException when divided by 0" in{

    assertThrows[ArithmeticException] {
      forValidatingDivideOpr.divide(10,0)
    }
  }

  //Fibonacci unit test case

  "When last term positive then it" should "generate the fibonacci series up to last term" in{
    val lastTerm=6
    assert(forValidatingFibonacciOpr.fibonacci(lastTerm).equals("0 1 1 2 3 5"))
  }

  "When last term negative then it" should " prints an error message" in{
    val lastElement= -10
    assert(forValidatingFibonacciOpr.fibonacci(lastElement).equals("Invalid Input"))
  }
}

