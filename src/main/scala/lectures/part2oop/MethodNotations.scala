package lectures.part2oop

import scala.language.postfixOps

object MethodNotations extends App{

  class Person(val name :String, favouriteMovie: String){
    // defining method inside person class
    def likes(movie: String): Boolean = movie == favouriteMovie

    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def unary_! : String = s"$name, what the heck?" // naming of function here is really important

    def isAlive: Boolean = true

    def apply(): String = s"Hi, my name is $name and I like $favouriteMovie"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))

  // INFIX NOTATION/ OPERATOR NOTATION
  // only works with methods that have single parameter
  // style of calling methods in infix notation is called SYNTACTIC SUGAR
  // SYNTACTIC SUGAR = nicer ways of writing code that's equivalent to more complex ways of writing code
  println(mary likes "Inception") // equivalent to the line of code above

  // "OPERATORS" in scala
  val tom = new Person("Tom", "Fight Club")
  println(mary hangOutWith tom) // the method 'hangOutWith' acts like an operator between mary and tom which yields a String
  // operators like + - etc aren't reserved in scala and they can be used as method names and be called on


  // ALL OPERATORS ARE METHODS
  // plus operators between numbers are methods as well - mathematical operators are acting the same way as methods bec they are methods
  // e.g.
  println(1 + 2) // is the same as below
  println(1.+(2))



  // PREFIX NOTATION
  // all about unary operators
  // unary operators are also methods
  // e.g.
  val x = -1 // - here is a unary operator
  val y = 1.unary_- // this is same as the line above

  // so unary operators are methods with unary underscore prefixed
  // unary_ prefixes only work with - + ~ !

  println(!mary) // this is equivalent to the line below
  println(mary.unary_!)

  // POSTFIX NOTATION
  // functions that don't take parameter have the property that they can be used in postfix notation
  // e.g.
  println(mary.isAlive) // this is the same as the line below
  println(mary isAlive)

  // APPLY
  // special method name
  println(mary.apply())
  // can call mary like its a function bec a method called apply has been defined in the Person class
  // when the compiler sees an object being called like a function, it looks for a definition of apply in that particular class
  println(mary()) // equivalent
}
