package com.rockthejvm.part2OOP

object OOBasics {

  class Person(name: String, age: Int) { // constructor signature
    // fields
    val allCaps = name.toUpperCase() // a field of every instance of person

    //methods - functions attached to every person instance
    def greet(name: String): Unit =
      println(s"${this.name} says: Hi, $name")// this refers to the current instance of the name field

    def greet(): String = s"my name is $name"

    // aux constructor - default arguments are usually a more straightforward way to do this
    def this(name:String) =
      this(name, 0) // instantiates the person without a number, calls to another instructor eg Person()

    def this()=
      this("Jane Doe")
  }

  val aPerson: Person = new Person("John", 9)
  val johnYelling = aPerson.allCaps
  val johnSayHiToDaniel = aPerson.greet("Daniel")
  val johnSayHi = aPerson.greet()
  val genericPerson = new Person()



  def main(args: Array[String]): Unit = {
//    println(johnSayHiToDaniel) // John says: Hi, Daniel
//    println(johnSayHi) // my name is John
//    println(genericPerson)

//    val aWriter: Writer = new Writer("Roald", "Dahl", 1916)
//    println(aWriter.fullName) // Roald Dahl
//    val aNovel: Novel = new Novel("The Twits", 1980, aWriter)
//    println(aNovel.authorAge)
//    val anotherWriter: Writer = new Writer("Roald", "Dahl", 2024)
//    println(aNovel.isWrittenBy(anotherWriter))
//    val newEdition = aNovel.copy(2020)
//    println(newEdition.authorAge)

    val counter = new Counter()
    counter.print()
    counter.increment().print()

  }
}


// #Exercise 1
// Novel and writer class
class Writer(firstName: String, lastName: String, yearOfBirth: Int) {
  def fullName: String = firstName + " " + lastName
  val birthYear: Int = yearOfBirth
}

class Novel(title: String, yearOfRelease: Int, author: Writer) {
  def authorAge: Int =  yearOfRelease - author.birthYear
  def isWrittenBy(author: Writer): Boolean = this.author == author
  def copy(newYear: Int): Novel = new Novel(this.title, newYear, this.author)

}

// #Exercise 2
// Immutable counter class

class Counter(count: Int = 0) {

  def increment(): Counter = {
    new Counter( count + 1)
  }
  def decrement(): Counter = {
    if (count == 0) this
    new Counter (count - 1)
  }
  def print(): Unit = {
    println(s"current count: $count")
  }
}

