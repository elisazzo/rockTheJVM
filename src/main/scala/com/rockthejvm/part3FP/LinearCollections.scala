package com.rockthejvm.part3FP

object LinearCollections {

  // Seq = well-defined ordering + indexing
  def testSeq(): Unit = {
    val aSequence = Seq(1, 2, 3, 4)
    // main API: index an element
    val thirdElement = aSequence.apply(2) // element 3
    // map/flatMap/filter/for
    val anIncrementedSequence = aSequence.map(_ + 1)
    val aFlatMappedSequence = aSequence.flatMap(x => Seq(x, x+1))
    val aFilteredSequence = aSequence.filter(_ % 2 == 0)

    // other methods
    val reversed = aSequence.reverse
    val concatenation = aSequence ++ Seq(5, 6, 7)
    val sortedSequence = aSequence.sorted // [1, 2, 3, 4]

    val sum = aSequence.foldLeft(0)(_+_) // 10
    val stringRep = aSequence.mkString("[", ",", "]")

    println(aSequence)
    println(concatenation)
    println(sortedSequence)
    println(aFlatMappedSequence)
  }

  // lists
  def testlists(): Unit = {
    val aList = List(1, 2, 3)
    // same API as Seq
    val firstElement = aList.head
    val rest = aList.tail

    // appending and prepending
    val aBiggerList = 0 +: aList :+ 4
    val prepending = 0 :: aList // :: equivalent to Cons in our Llist

    // utility methods
    val scalax5 = List.fill(5)("Scala")
    println(scalax5)
  }

  // ranges
  def testRanges(): Unit = {
    val aRange = 1 to 10
    val aNonInclusiveRange = 1 until 10
    // same Seq API
//    1 to 10 forEach (_ => println("Scala"))
  }

  // arrays
  def testArrays(): Unit = {
    val anArray = Array(1, 2, 3, 4, 5, 6)
    // access to most Seq API *BUT NOT A SEQ*
    val aSequence = anArray.toIndexedSeq
    // arrays are mutable
    anArray.update(2, 30) // does  not create a new Arr
  }

  // vectors = fast Seq for a large amount of data
  def testVectors(): Unit = {
    val aVector: Vector[Int] = Vector(1, 2, 3, 4, 5)
    // same Seq API
  }

  // sets - do not contain duplicates
  def testSets(): Unit = {
    val aSet = Set(1, 2, 3, 4, 5, 4)
    // equals + hashCode = hash set
    // main API: tests if in the set
    val contains3 = aSet.contains(3) //true
    val contains3_v2 = aSet.apply(3) // remove .apply => aSet(3)
    // adding/ removing
    val aBiggerSet = aSet + 4 // [1, 2, 3, 4, 5]
    val aSmallerSet = aSet - 4 // [1, 2, 3, 5]
    // concatenation
    val anotherSet= Set(5, 6, 7, 8)
    val muchBiggerSet = aSet.union(anotherSet) 
    val muchBiggerSet_v2 = aSet ++ anotherSet
    println(muchBiggerSet_v2)
    // difference
    val aDiggSet = aSet.diff(anotherSet)
    // intersection
    val anIntersection = aSet.intersect((anotherSet))


  }

  def main(args: Array[String]): Unit = {
//    testSeq()
//    testlists()
    testSets()
  }


}

