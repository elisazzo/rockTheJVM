package com.rockthejvm.part2OOP

object Exceptions { // special instances that can crash the application

  val aString: String = null // aString.length crashes with a NPE

  // 1. Throw expections
//  val aWeirdValue: Int = throw new NullPointerException()
  // type Throwable
    // Error, e.g. Stack Overflow Error (no more stack memory on the JVM to add another function call), Out of Memory Error (no more memory to allocate)
    // Exception, e.g. NPException, NSEException


  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No int for you!")
    else 42

  // catching exceptions
  val potentialFail = try {
    // code that might fail
    getInt(true) // an Int
  } catch {
    // most specific exceptions first
    case e: RuntimeException => 54 // an Int
    case e: NullPointerException => 35
    // ...
  } // compiler will infer that the try catch expression returns an int (based on the try/ catch return options)
  finally {
    // optional piece of code that will always run - e.g. close resources
  } // no impact on return type , returns unit

  // define custom exceptions v
  class MyException extends RuntimeException {
    // fields or methods
    override def getMessage = "my exception"
  }

  val myException = new MyException



  def main(args: Array[String]): Unit = {

    //    println(aString.length)
    println(potentialFail)
    val throwingMyException = throw myException
  }
}
