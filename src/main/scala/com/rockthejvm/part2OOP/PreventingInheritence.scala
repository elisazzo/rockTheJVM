package com.rockthejvm.part2OOP

object PreventingInheritence {

  class Person(val name: String) {
    final def enjoyLife(): Int = 42 // prevents override
  }

  class Adult(name: String) extends Person(name){
    // override def enjoyLife(): Int = 999 // illegal due to final keyword
  }

  final class Animal // final prevents inheritance
  // class Cat extends Animal // illegal due to final keyword

  // sealing a type hierarchy = inheritance only permitted inside this file
  sealed class Guitar(nStrings: Int) // sealed restricts inheritance of guitar class outside of this file
  class ElectricGuitar(nStrings: Int) extends Guitar(nStrings)
  class AcousticGuitar(nStrings: Int) extends Guitar(6)

  // no modifier = "not encouraging inheritance"
  
  // open
  open class ExtensibleGuitar(nStrings: Int) // add documentation e.g. open = specifically marked for extension

  def main(args: Array[String]): Unit = {

  }

}
