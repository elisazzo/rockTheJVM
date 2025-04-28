package com.rockthejvm.part1basics

object Expressions {

  // expressions are structures that evaluate to a value
  val meaningOfLife = 40 + 2

  // mathematical expressions: +, -< * /, bitwise |, &, <<, >>, >>>
  val mathExpression = 2 + 3 * 4

  // comparison expressions: <, <=, >, >=, ==, !=
  val equalityTest = 1 == 2 // returns a boolean

  // boolean expressions: !, ||, &&
  val nonEqualityTest = !equalityTest

  // intructions vs expressions
  // instructions are executed, eg "do x, do y, then do z"
  // expressions are evaluated (structures that are collapsed to a value) 

  def main(args: Array[String]): Unit = {
    println(nonEqualityTest)
  }

}
