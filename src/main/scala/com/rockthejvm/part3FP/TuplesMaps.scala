package com.rockthejvm.part3FP

object TuplesMaps {

  // tuples = finite ordered "lists" / group of values under one single "big" value
  val aTuple = (2, "rock the jvm") // Tuple2[Int, String] == (Int, String)
  val firstField = aTuple._1
  val aCopiedTuple = aTuple.copy(_1 = 54)

  // tuples of 2 elements
  val aTuple_v2 = 2 -> "rock the jvm" // IDENTICAL to (2, "rock the jvm")

  // maps: keys -> values
  val aMap = Map()

  val phonebook = Map[String, Int](
    "Jim" -> 555,
    "Daniel" -> 789,
    "Jane" -> 123
  ).withDefaultValue(-1)

  // core APIs
  val phonebookHasDaniel = phonebook.contains("Daniel")
  val marysPhoneNumer = phonebook.apply("Mary") // crash with an exception // or returns default value

  // add a pair
  val newPair = "Mary" -> 678
  val newPhonebook = phonebook + newPair // new map

  // remove a key
  val phonebookWithoutDaniel = phonebook - "Daniel" // new map

  // list -> map
  val linearPhonebook = List(
    "Jim" -> 555,
    "Daniel" -> 789,
    "Jane" -> 123
  )
  val phonebook_v2 = linearPhonebook.toMap

  // map -> linear collection
  val linearPhonebook_v2 = phonebook.toList // toSeq, toVector, toArray, toSet

  // map, flatMap, filter
  val aProcessedPhonebook = phonebook.map(pair => (pair._1.toUpperCase(), pair._2))

  // filtering keys *this is dangerous*
  val noJs = phonebook.view.filterKeys(!_.startsWith("J")).toMap

  // mapping values
  val preficNumbers = phonebook.view.mapValues(number => s"0255-$number").toMap

  // other collections can create maps
  val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim")
  val namesGroupings = names.groupBy(name => name.charAt(0)) // Map[Char, List[String]]


  def main(args: Array[String]): Unit = {
    println(phonebook)
    println(phonebookHasDaniel)
    println(marysPhoneNumer)
    println(namesGroupings)

  }

}
