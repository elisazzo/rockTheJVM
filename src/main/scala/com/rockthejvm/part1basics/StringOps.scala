package com.rockthejvm.part1basics

object StringOps {

  val aString: String = "test string example"

  // string functions
  val secondChar = aString.charAt(1) // "t"
  val firstWord = aString.substring(0, 5) // "test"
  val words = aString.split(" ") // Array("test", "string", "example"
  val startsWith = aString.startsWith("test") // true
  val allDashes = aString.replace(" ", "-")

  // other functions
  // aString.reverse swaps the char order
  // aString.take(10) returns a string containing the first 10 characters
  // .toInt converts strings to Int eg "2" becomes 2



  def main(args: Array[String]): Unit = {

  }
}
