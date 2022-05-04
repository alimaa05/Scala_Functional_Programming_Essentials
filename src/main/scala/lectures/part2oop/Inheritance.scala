package lectures.part2oop

object Inheritance extends App{

  // single class inheritance - can only extend once class at a time
  class Animal { // can put final at the front would prevent the entire class from being extended
    val creatureType = "wild"
     protected def eat = println("nomnom") // final instead of protected means this method will be prevented from being overridden
  }

   class Cat extends Animal {
    def crunch  = {
      eat
      println("crunch crunch")
    }

  }
  // subclass only inherits non private members of the superclass
  val cat = new Cat
//  cat.eat // can call eat function on the instance of cat bec extending a class means inheriting all the non private fields and methods


  // 'protected' access modifier - means the method is only usable within this class and within subclasses
  // allows the use of the method 'eat' inside the subclass too but not accessible outside the subclass


  // ACCESS MODIFIERS allowed in scala are private, protected and no modifier i.e. default - public

  //---------------------------------------


  // CONSTRUCTORS
  class Person(name: String, age: Int) {
    // Defining a class like this with class signature also defines its constructor

    // define auxiliary constructor e.g. for Person
    // with the implementation that this class calls the constructor with name and the age 0
    def this(name: String) = this(name,0)
  }


  // this code won't compile bec when you instantiate a derived class i.e. Adult, JVM will need to call a constructor from a parent class first
  // i.e. needs to call a constructor of person before you call the constructor of adult
  class Adult( name: String, age: Int, idCard: String) extends Person(name, age)

  //---------------------------------------

  // OVERRIDING

  // dog extends animal

  class Dog(override val creatureType: String) extends Animal {
    // applying a different implementation for the protected def eat method do this using 'override' keyword
//    override val creatureType = "domestic"
    override def eat = {
      super.eat // will refer to the method eat in the super class
      println("crunch crunch")
}

    // THIS ABOVE IS LIKE THIS BELOW
//    class Dog(dogType: String) extends animal {
//      override val creatureType = dogType
//    }

    val dog = new Dog("K9")
    dog.eat
  }

  // override works for methods as it does for values and vars

  // fields compared to methods have the special property that they can be overridden directly in the constructor as well - see line class Dog parameter


  // as a shorthand you can override fields from superclasses directly in the constructor
  // main idea of overriding is that all instances of derived classes will use the overridden things whenever possible

  //---------------------------------------


  // TYPE SUBSTITUTION i.e. polymorphism

  val unknownAnimal: Animal = new Dog("K9")
// can declare something to be an animal and supply a dog instead

  // a method call with always go to the most overridden version whenever possible

  //---------------------------------------

  // OVERRIDING vs OVERLOADING
  // the former --> supplying a different implementation in derived classes
  // the latter --> supplying multiple methods with different signatures but with the same name in the same class

  //---------------------------------------

  // SUPER
  // used when you want to reference a method or field from parent class

  //---------------------------------------

  // PREVENTING OVERRIDES
  // there are cases when you want to limit the overrides of your fields or methods and there are a few ways to do this

  // 1. use the 'final' keyword on member
  // prevent derived classes from overriding the eat method
  // 2. use 'final' on the superclass
  // 3. seal the class - using 'sealed' keyword when creating the class
  // this is a softer restriction
  // you can extend classes in this file BUT prevents extension in other files
  // usually used when you want to be exhaustive in your type hierarchy
}
