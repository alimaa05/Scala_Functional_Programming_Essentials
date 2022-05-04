package lectures.part2oop

object Objects extends App{


  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static")
  // this would be the equivalent

  //to use class level definitions scala uses OBJECTS
  object Person {   // an object can have values or vars and can have method definitions
    // 'static'/'class' level functionality
    val N_EYES =2
    def canFly: Boolean = false

    // factory method  --> sole purpose is to build Persons given some parameters
    // in practice the factory methods are called apply instead of something else like 'from'
//    def from(mother: Person, father: Person) : Person = new Person("Bobbie")
    def apply(mother: Person, father: Person) : Person = new Person("Bobbie")

  }

  //---------------------------------------

 // Creating a class and object with same name in the same file or same scope for practical reasons - this is to separate instance level functionality from 'static'/'class' level functionality
  class Person (val name: String) {
   // instance level functionality
 }

  // COMPANION - pattern of writing classes and objects with the same name in the same scope
  // the entire code here will either reside in a class (can access it from an instance)
  // OR it will reside in the inside of a singleton object (can be accessed through singleton object and means that all the code will ever be accessed will be accessed from some sort of instance (either regular or singleton)



  println(Person.N_EYES) // can access them in a class level setting
  print(Person.canFly)

  //---------------------------------------

  // in scala objects are used as singleton instance
  // i.e. when you define object person, basically defining its type but also its only instance
  // a singleton object is where there is a single instance that can be referred to with the name Person

  // e.g. create variable
  // giving it the value of Person
  // this is an instance of the person type, which is the only instance that this person type can have
  val mary = Person
  // creating another variable with the Person value
  val john = Person

  // they point to the same instance i.e. the object Person
  println(mary == john)

  //---------------------------------------

  // creating them as new instance
  val maryy = new Person("Mary")
  // creating another variable with the Person value
  val johnn = new Person("John")

  // they point to the same instance i.e. the object Person
  println(maryy == johnn) // this would be false bec these are two new instances of the Person class

//  val bobbie = Person.from(maryy,johnn)
  // instead of calling .from bec we called the method apply, we can do the following
  val bobbie = Person(maryy,johnn)

  //---------------------------------------

  // Scala Applications
  // is scala object with particular and important method called def main(args: Array[String]) : Unit
  // needs this exact definition bec scala applications are turned into JVM applications whose entry point have to be static
  // i..e Public static void main, with array of String as parameter

  // short hand version is to include extends App at the top of the class object
}
