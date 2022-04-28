package lectures.part2oop

object OOPBasics extends App{

    val person = new Person ("John", 26)
    // to instantiate the class person, assign to val - and instantiation of a class requires 'new' keyword
    // then name of the class

    println(person.age)
    println(person.x)
    person.greet("Alimaa")

println("--------------------------------------------------")

  val khaled = new Writer("Khaled ", "Hosseini" , 1965)


  println(khaled.yearOfBirth)
  println(khaled.fullname)

  println("--------------------------------------------------")

  val novel = new Novel("A Thousand Splendid Suns",2007, khaled )

  println(novel.authorAgeAtRelease)
  println(novel.writtenBy)

  println(novel.newRelease(2022).yearOfRelease)

  println("--------------------------------------------------")

  val counter = new Counter(5)

  println(counter.decrementCounter.count)
  println(counter.incrementCounter.currentCount)

  println(counter.decrementCounter(4).currentCount)
  println(counter.incrementCounter(4).currentCount)

}


//------------------------------------------------------------------------------------------------

// WRITING A CLASS
  // write the class outside the object implementation bec class definitions can sit on top level code

  class Person(name :String, val age:Int = 0) {  // passing parameters to a class --> constructor
    // every instance of person must be constructed by passing in a name and age
    // age and name are class parameter but not class member that you can access with dot operator
    // class parameters are not fields
    // class parameter from the constructor and class fields which you can access are two different things
    // to convert class parameter to field add val or var keyword

    //------------------------------------------------------------------------------------------------

    //BODY - defines the implementation of this class
    // block of code inside can have everything including val, var definitions, function definitions, expressions
    // can have other definitions like packages and other classes

    //E.G.
    val x = 2  // val or var definitions inside class implementations are fields

    println(1+3)
    // this will also be evaluated bec at every instantiation of class person the whole block of code will be evaluated
    // so every expression within herE and side effects will be executed

    //------------------------------------------------------------------------------------------------

    // DEFINING FUNCTIONS

    // bec this function is defined inside the class definition is called a METHOD
    // if you call this method - use the dot notation
    def greet(name: String): Unit = println(s"${this.name} says: Hi, $name") // accessing this instances field using this.

    // overloading - means defining methods with the same name but different signatures
    // different signatures means different numbers of parameters or parameters of different types as well as possibly different return types
    def greet(): Unit = println(s"Hi, I am $name")

    //------------------------------------------------------------------------------------------------

    // MULTIPLE CONSTRUCTORS
    // can do this using 'def this'

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
 //------------------------------------------------------------------------------------------------
    /* Exercises
      * Writer and novel class
       writer : first name, surname, year of birth
       - method full name
      * novel: name,year of release, author
       - author age (age of author at year of release)
       - is written by author
       - copy (receives a new year of release - returns new instance of novel)

      * counter class
      - receives int value
      - method that return current count
      - method to increment and decrement counter by one - return a new counter
      - overload the increment and decrement methods to receive a parameter which is the amount by which you're increment or decrement the counter - result would be new counter
     */

// writer class
    class Writer (val firstname :String, val surname :String, val yearOfBirth :Int = 1999 ) {
      def fullname:String = (s"$firstname" + s"$surname")
    }

// novel class
    class Novel (val name :String, val yearOfRelease :Int, writer: Writer){

      def authorAgeAtRelease: Int = (yearOfRelease - writer.yearOfBirth)

      def writtenBy: String = (writer.fullname)

      // creating a new instance with diff year of release
      def newRelease(newReleaseYear: Int) = new Novel(name, newReleaseYear, writer)


    }

    class Counter (val count :Int) {

      def currentCount = count

      def incrementCounter = new Counter(count+1) //immutability - instances are fixed

      def decrementCounter = new Counter(count-1)

      // overloading
      def incrementCounter(inc: Int) = new Counter(this.count+inc)

      def decrementCounter(dec: Int) = new Counter(this.count-dec)


    }



    

