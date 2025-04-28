//package com.rockthejvm.part2OOP
//
//object MethodNotation {
//  
//  class Person(val name: String, favMovie: String){
//    //infix notation
//    infix def likes(movie: String): Boolean =
//      movie == favMovie
//      
//    //operators
//    infix def +(person:Person): String =
//      s"${this.name} likes ${person.name}"
//      
//      //prefix position
//      def unary_- : String =
//        s"$name's alter ego"
//  }
//  
//  val mary = new Person("Mary", "Inception")
//  val john = new Person("John", "Fight Club")
//  
//  val negativeOne = -1
//
//  
//  def main(args: Array[String]): Unit = {
//    println(mary.likes("Fight Club")) // false
//    //infix notation - ONE argument
//    println(mary likes "Fight Club") // false
//    
//    //operator
//    println (mary + john) // Mary likes John
//    println(mary.+(john)) // Mary likes John
//    
//    //prefix
//    println(-mary)
//    println(mary.unary_-)
//  }
//  
//  
//
//}
