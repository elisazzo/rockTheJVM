package com.rockthejvm.part3FP

object MapFlatMapFilterFor {

  // standard list
  val aList = List(1, 2, 3) // [1] -> [2] -> [3] -> Nil
  val firstElement = aList.head
  val restOfElements = aList.tail

  // map
  val anIncrementedList = aList.map(_ + 1)

  // filter
  val onlyOddNumbers = aList.filter(_ % 2 != 0) // returns bool

  // flatMap
  val toPair = (x: Int) => List(x, x + 1)
  val aFlatMappedList = aList.flatMap(toPair) // apply toPair to every single element
  // 1) map aPair over aList =>
  // List(List(1, 1 + 1), List(2, 2 + 1), List(3, 3 + 1)
  // List(List(1, 2), List(4, 1), List(6, 1))

  // 2) flatMap the list of lists into one level
  // List(1, 2, 2, 3, 3, 4)

  //
  val numbers = List(1, 2, 3,4)
  val chars = List("a", "b", "c", "d")
  val colors = List("black", "white", "red")
  val numbersAndChar = (number: Int) => chars.map((char: String) => s"$number$char")
  val numbersAndCharAndColors = (numbersAndCharStr: String) => colors.map((colorStr: String) => s"$numbersAndCharStr - $colorStr")

   val numbersAndCharList = numbers.flatMap(numbersAndChar)
   val numbersAndCharAndColorsList = numbersAndCharList.flatMap(numbersAndCharAndColors)

   val combinations = numbers.withFilter(_ % 2 == 0) flatMap(number => chars.flatMap(char => colors.map(color => s"$number$char - $color")))

   // for-comprehension // the same as flatMap + Map chains // NOT iteration
   val combinationsFor = for {
     number <- numbers if number % 2 == 0  // for every number in numbers // the same as filter but is actually calling withFilter // will not compile with filter alone
     char <- chars
     color <- colors
   } yield  s"$number$char - $color"

   // for-comprehensions can also be used with unit eg println

   // for-comprehension LList
   import com.rockthejvm.practice.*
   val lSimpleNumbers: LList [Int] = Cons(1, Cons(2, Cons(3, Empty())))
   // map, flatMap, filter
   val incrementedNumbers = lSimpleNumbers.map(_+1)
   val filteredNumbers = lSimpleNumbers.filter(_%2==0)
   val toPairLlist: Int => LList[Int] = (x: Int) => Cons(x, Cons(x +1, Empty()))
   val flatMappedNumbers = lSimpleNumbers.flatMap(toPairLlist)

  // map + flatMap = for comprehensions
   val combinationNumbers = for {
     number <- lSimpleNumbers
     char <- Cons('a', Cons('b', Cons('c', Empty())))
   } yield s"$number$char"


  def main(args: Array[String]): Unit = {
    println(incrementedNumbers)
    println(filteredNumbers)
    println(flatMappedNumbers)

    println(combinationNumbers)
  }

}
