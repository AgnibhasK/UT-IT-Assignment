package com.knoldus.impl
import com.knoldus.traits.DivideAndFibonacci
class DivideAndFibonacciImpl extends DivideAndFibonacci {

  // method to divide two numbers
  override def divide(dividend: Int, divisor: Int): Int = a / b

  //method to generate fibonacci series.
  override def fibonacci(lastTerm: Int): String = {
    var (prevTerm,nextTerm,sum,i)=(0,1,0,2)
    var fibonacciSeriesStr= prevTerm+" "+nextTerm

    if(lastTerm<0)
      return "Invalid Input"
    else if(lastTerm==1)
      return "0"
    else if(lastTerm==2)
      return fibonacciSeriesStr

    while (i<lastTerm) {
      sum = prevTerm + nextTerm
      fibonacciSeriesStr+=" "+sum
      prevTerm = nextTerm
      nextTerm = sum
      i+=1
    }

  fibonacciSeriesStr
  }
}

