package com.rockthejvm.part1basics

object Functions {

  // with arguments
  def aFunction(a: String, b: Int): String = a + " " + b
  val aFunctionInvocation = aFunction("Scala", 1)

  // without arguments - the following two functions are the same but use different styles
  def aNoArgFunction(): Int = 45
  def aParameterlessFunction: Int = 45

  // recursive functions - can call itself in its definition
  def stringConcatenation(str: String, n: Int): String =
    if (n == 0) " "
    else if (n == 1) str
    else str + stringConcatenation(str, n-1)

  val evaluatedFunction = stringConcatenation("scala", 3)

  def aGreetingFunction(name: String, age:Int): String = {
    val greeting = s"Hi my name is ${name} and I am ${age} years old"
    greeting
  }

  def aFactorialFunction(n: Int): Int = {
    if (n <= 0) 0
      else if (n == 1) 1
    else n * aFactorialFunction(n - 1)
  }

  def aFibonacciFunction(n: Int): Int = {
    if (n <= 2) 1
    else aFibonacciFunction((n -1) + aFibonacciFunction(n-2))
  }

  def isPrime(n: Int): Boolean = {
true
  }

  def main(args: Array[String]): Unit = {
  println(evaluatedFunction)
  }

}
