package com.rockthejvm.part4power

object ImperativeProgramming {

  val meaningOfLift: Int = 42

  var aVariable = 99
  aVariable = 11 // vars can be reassigned
  aVariable += 10 // aVariable + 10

  //  loops 
  def testLoop(): Unit = {
    var i = 0
    while (i < 10)
      println(s"Counter at $i")
      i += 1
  }
  
  // imperative programming is not recommended: hard to read, difficult to understand, vulnerable to concurrency issues
  // can be useful for performance critical applications

  val anExpression: Unit = aVariable += 10
  val aLoop: Unit = while(aVariable < 130){ 
    println("counting more")
    aVariable += 1
  }

  def main(args: Array[String]): Unit = {
    testLoop()
  }

}
