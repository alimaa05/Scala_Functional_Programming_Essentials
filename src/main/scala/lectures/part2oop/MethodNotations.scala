package lectures.part2oop

import scala.language.postfixOps

object MethodNotations extends App{


//  2. add age to person class with default 0 value
  class Person(val name :String, favouriteMovie: String, val age :Int = 0){
    // defining method inside person class
    def likes(movie: String): Boolean = movie == favouriteMovie

    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    // 1. overload the plus (infix)operator - receives a String and returns a new Person with nickname
    def +(nickname: String): Person = new Person (s"$name ($nickname)", favouriteMovie)

    def unary_! : String = s"$name, what the heck?" // naming of function here is really important

  // Q2. add unary plus operator that increments value of person with age + 1 - returns new person
  def unary_+ : Person = new Person (name, favouriteMovie, age +1)

    def isAlive: Boolean = true

    def apply(): String = s"Hi, my name is $name and I like $favouriteMovie"

//   3. add a "learns" method in person class => "Mary learn Scala"
//   add learnsScala method - calls learns method with 'scala'
    def learns (thingLearning: String) = s"$name learns $thingLearning"

    def learnsScala = this learns "Scala"

//  4. overload the apply method to take Int parameter and overload the String
//  mary.apply(2) => "Mary watched Inception 2 times"
    def apply(n :Int): String = s"$name watched $favouriteMovie $n times"

  }

  val mary = new Person("Mary", "Inception", 22)
  println(mary.likes("Inception"))


  //-------------------------------------------------------------------------

  // INFIX NOTATION/ OPERATOR NOTATION
  // only works with methods that have single parameter
  // style of calling methods in infix notation is called SYNTACTIC SUGAR
  // SYNTACTIC SUGAR = nicer ways of writing code that's equivalent to more complex ways of writing code
  println("------------------------INFIX NOTATION-------------------")

  println(mary likes "Inception") // equivalent to the line of code above

  //--------------------------------------------------------------------------

  // "OPERATORS" in scala
  val tom = new Person("Tom", "Fight Club")
  println("------------------------OPERATORS------------------------")
  println(mary + tom) // the method 'hangOutWith' acts like an operator between mary and tom which yields a String
  // operators like + - etc aren't reserved in scala and they can be used as method names and be called on


  // ALL OPERATORS ARE METHODS
  // plus operators between numbers are methods as well - mathematical operators are acting the same way as methods bec they are methods
  // e.g.
  println("-------------------ALL OPERATORS ARE METHODS-------------")
  println(1 + 2) // is the same as below
  println(1.+(2))


  //-------------------------------------------------------------------------


  // PREFIX NOTATION
  // all about unary operators
  // unary operators are also methods
  // e.g.
  val x = -1 // - here is a unary operator
  val y = 1.unary_- // this is same as the line above

  // so unary operators are methods with unary underscore prefixed
  // unary_ prefixes only work with - + ~ !

  println("------------------------PREFIX NOTATION-----------------")

  println(!mary) // this is equivalent to the line below
  println(mary.unary_!)

  //-----------------------------------------------------------------------------------------

  // POSTFIX NOTATION
  // functions that don't take parameter have the property that they can be used in postfix notation
  // e.g.

  println("------------------------POSTFIX NOTATION---------------")

  println(mary.isAlive) // this is the same as the line below
  println(mary isAlive)

  //-------------------------------------------------------------------------------------------


  // APPLY
  // special method name

  println("------------------------APPLY-------------------------")

  println(mary.apply())
  // can call mary like its a function bec a method called apply has been defined in the Person class
  // when the compiler sees an object being called like a function, it looks for a definition of apply in that particular class
  println(mary()) // equivalent

  println("------------------------EXERCISES---------------------")

  // EXERCISES
  /*
    * 1. overload the plus (infix)operator - receives a String and returns a new Person with nickname
    * e.g. mary + "the rockstar" => new Person "Mary (the rockstar)"

    * 2. add age to person class with default 0 value
    * add unary plus operator that increments value of person with age + 1
    * e.g. +mary => mary with age incremented

    * 3. add a "learns" method in person class => "Mary learn Scala"
    * add learnsScala method - calls learns method with 'scala'
    * use it in postfix notation

    * 4. overload the apply method
    * mary.apply(2) => "Mary watched Inception 2 times"
   */


  // Q1
  println((mary + "the rockstar")())

  println("-------")

  // Q2
  //  e.g. +mary => mary with age incremented
  println((+mary).age)

  println("-------")

  // Q3
  // use it in postfix notation
  println(mary learnsScala)

  println("-------")

  //Q4

  println(mary apply(2))

}
