package lectures.part2oop

object AbstractDataTypes extends App{

  //ABSTRACT - classes that contain unimplemented or abstract fields or methods defined by keyword 'abstract'

  abstract class Animal {
    val creatureType: String = "wild"
    def eat: Unit
// abstract classes can't be instantiated - instance of a class has to have all these method implemented
    // abstract classes and abstract data types are means to be extended later

  }

  class Dog extends Animal {
    // private implementation on the abstract fields
    override val creatureType: String = "canine"
    override def eat = println("crunch crunch")
  }

  //---------------------------------------

  //TRAITS
  // ultimate abstract data types in scala
  // using keyword 'trait'

  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferredMeal: String = "fresh meat"
  }

  // like abstract classes have abstract fields and methods BUT they can be inherited along classes
  // e.g.
  class Crocodile extends Animal with Carnivore{
    // means class Crocodile inherits members from Animal and Carnivore
     override val creatureType: String = "croc"
     def eat: Unit = println("nomnomnom")
     def eat (animal: Animal): Unit = println(s"I'm a croc and i'm eating ${animal.creatureType}")
  }
  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  // you can extend a class with a trait - can mix multiple traits

  //---------------------------------------


  // TRAITS VS ABSTRACT CLASSES
    // abstract classes can have abstract and non-abstract types
    // traits can also have abstract and non-abstract classes

    // 1 -traits DON'T have constructor parameters

    // 2 -you can only extend one class but can have multiple traits (multiple traits by same class)

    // 3 -traits are behaviours BUT abstract type is a type of thing

  //---------------------------------------


  // SCALA TYPE HIERARCHY

  // starts with type 'any' - mother of all types

  // derived from 'any' is 'anyRef' - mapped to java's object type
  // all classes will derive from 'anyRef' unless explicitly told it extends another class

  // derived from this is '.Null' - its only only instance is null reference i.e. means no reference
  // null extends basically everything in the sense ypu can replace anything e.g. 'person' with no reference

  // also derived from 'any' is 'AnyVal' - contains all primitive values e.g. int, unit, boolean etc.

  // derived from all of these is '.Nothing' - nothing can replace everything - nothing is a subtype of every single thing in scala
  // nothing means no instance of anything at all


  //---------------------------------------



}
