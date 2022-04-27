package lectures.part2oop

object OOBasics extends App{

  val person = new Person ("John", 26)
  // to instantiate the class person, assign to val - and instantiation of a class requires 'new' keyword
  // then name of the class

  println(person.age)
  println(person.x)
  person.greet("Alimaa")
}

// write the class outside the object implementation bec class definitions can sit on top level code

class Person(name :String, val age:Int = 0) {  // passing parameters to a class --> constructor
  // every instance of person must be constructed by passing in a name and age
  // age and name are class parameter but not class member that you can access with dot operator
  // class parameters are not fields
  // class parameter from the constructor and class fields which you can access are two different things

  // to convert class parameter to field is add val or var keyword


  //body - defines the implementation of this class
  // block of code inside can have everything including val, var definitions, function definitions, expressions
  // can have other definitions like packages and other classes

  val x = 2  // val or var definitions inside class implementations are fields

  println(1+3)
  // this will also be evaluated bec at every instantiation of class person the whole block of code will be evaluated
  // so every expression within her and side effects will be executed

    // defining functions

  // bec this function is defined inside the class definition is called a method
  // if you call this method - use the dot notation
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name") // accessing this instances field using this.

  // overloading - means defining methods with the same name bit different signatures
  // different signatures means different numbers of parameters or parameters of different types as well as possibly different return types
  def greet(): Unit = println(s"Hi, I am $name")

  // multiple constructors
  // can do this using def this

  // e.g. auxiliary constructor that initialises the age with 0
  // so only takes name as parameter and calls the primary constructor with this(name, 0)
  // implementation of auxiliary constructor with only name parameter actually calls the primary constructor with 'this' keyword and 2 parameters
  // but issue is the implementation of secondary constructor has to be another constructor and nothing else
  def this (name: String) = this(name, 0)

  // define another constructor with no parameters and initialise this
  def this() = this("John Doe") // this is the only implementation an auxiliary constructor can have which is to call another constructor

  // this limitation make auxiliary constructors impractical bec they're only used in practice for default parameters
  // it can be more easily solved by supplying a default parameter to the actual class definition
  // default parameters actually work for constructors as well
}

