package com.rockthejvm.part2OOP

object AccessModifers {

  class Person(val name: String) {
    protected def sayHi(): String = s"Hi, my name is $name. " // protected methods can only be called inside the class or children classes
    private def watchNetflix(): String = "I am watching netflix. " // can only be called inside the class
  }

  class Kid(override val name: String, age: Int) extends Person(name) {
    def greetPolitely(): String = // no modifer = "public"
      sayHi() + "I love to play." // protected method can be called as Kid extends Person (is a child class)
//      sayHi() + "I love to play." + watchNetflix() illegal due to private method
  }

  // complication
  class KidWithParents(override val name: String, age: Int, momName: String, dadName: String) extends Person(name){
    val mom = new Person(momName)
    val dad = new Person(dadName)

//    def everyoneSayHi(): String =
//      this.sayHi() + s"Hi, I'm $name and here are my parents " + mom.sayHi() + dad.sayHi()
//      method sayHi cannot be accessed as a member of mom/ dad but can be accessed on THIS instance of Person
    
  }

  val aPerson = new Person("Alice")
  val aKid = new Kid("John", 6)

  def main(args: Array[String]): Unit = {
    // println(aPerson.sayHi()) // illegal due to protected method
    println(aKid.greetPolitely()) // Hi, my name is John. I love to play.
  }

}
