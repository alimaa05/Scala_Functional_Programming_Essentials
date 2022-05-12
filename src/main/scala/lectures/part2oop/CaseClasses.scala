package lectures.part2oop

object CaseClasses extends App {

  // case classes are a good shorthand way to define a class and companion objects and lot of sensible defaults in one go

  case class Person(name: String, age: Int)

  // 1. class parameters are fields
  val jim = new Person("Jim", 34)
  println(jim.name) // this is possible bec its a case class

  // 2. sensible toString for ease of debugging
  // println(instance) = println(instance.toString) - another form of syntactic sugar
  println(jim.toString)

  // 3. equals and hashCode implemented out of the box - makes case classes really important for use in collections
  val jim2 = new Person("jim", 34)
  println(jim == jim2) // this returns true - if didn't use keyword 'case' would have returned false bec jim and jim2 are different instances of class Person

  // 4. case classes have handy copy methods
  // instead of defining new Person with same parameters as Jim can use .copy
  val jim3 = jim.copy(age = 45) // .copy creates new instance of the case class
  // .copy method also receives a parameter
  println(jim3)

  // 5. case classes have companion objects
  val thePerson = Person
  // Person is the companion object of this case class - bec used the keyword case, makes the compiler automatically create companion objects for this class
  val mary = Person("Mary", 22)
  // companion objects apply method does the same thing as the constructor
  // in practice we don't use the keyword 'new' when instantiating a case class - only use this

  // 6. case classes are serialisable - makes classes esp useful when dealing with distributed systems
  // - can send instances of case classes through the network and in between JVMs
  // important when dealing with e.g. Akka framework

  // 7. case classes have extractor patters - can be used in PATTERN MATCHING

  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
    // case objects are like case classes except they don't get companion objects bec they are their own companion objects
  }
}
