package lectures.part2oop

object Generics extends App{

  // create a class and pass parameter with type A which demotes a generic type
  // can give the type parameter whatever name you want
  class MyList[A] {
    // now can use type a in the class definition
  }
  // this code gets reused for every single possible type that can be stored inside the generic list

  // you can also have multiple type parameters
  // can have two type parameters between sq brackets
  class MyMap[Key, Value]
  val listOfIntegers = new MyList[Int] // so type in here will replace generic type A for this instance of listOfIntegers
  val listOfString = new MyList[String]

  // traits can also be type parameterised

  // GENERIC METHODS
  // objects can't be type parameterised
  object MyList {
    def empty[A]: MyList[A] = ???
    //once to declare type parameter here, you can later use it in the function definition
  }
  val emptyListOfInterger= MyList.empty[Int]


  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // BASIC VARIANTS OPTIONS
  // does a List of cat extend a List of animal
  // 1- yes --> COVARIANCE
  class CovariantList[+A]
  val animalList: CovariantList[Animal] = new CovariantList[Cat]

  // can you add any animal to it?
  // e.g. animalList.add(new Dog) - adding an animal to animal list which is acc a list of cats would pollute the list of animals

  // can d this bec Cats are Animals

  // ----------------------------------

  // 2. no - list of cat and list of animal are two sep things
  // ie. INVARIANCE
  class InvariantList[A] // specify type parameter without any signs before or after it
  // invariant classes are each in its own world - can't substitute one for another
  // if you have this :
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]
  // can't substitute this with a new invariant list of cat or invariant list of anything else has to be whatever you passed before the equals sign


  // ----------------------------------

  // 3. Defo no
  // CONTRAVARIANCE
  class ContravariantList[-A] // type parameter has a minus sign before it
  // used like so:
  // using the derived class
  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]

  // replacing list of cats with list of animals - even though cat is a subtype of animals the relationship is opp and doesn't make sense

  // but now instead of covariant list - create a class called trainer
  class Trainer[-A] // basically trains animals
  val trainer: Trainer[Cat] = new Trainer[Animal] // the symantics of this will change now
  // can use a trainer of animal to be a trainer of cat - trainer of animal can train diff animals

  // bounded types
  // allow you to use your generic classes only for certain types that are either subclasses of different type or a super class of different type
  class Cage[A <: Animal](animal: A)  // upper bounded type   - lower bounded type is with > instead and means Cage only accepts something which is super type of animal
  // this means that class Cage only accepts type parameters A that are subtypes of Animal
  // received a parameter of  Animal that is of type A
  val cage = new Cage(new Dog) // this is an acceptable type for cage

//  class Car
//  val newCage = new Cage(new Car)
  // can't write newCage equals new cage of a new car - bec car doesn't subclass animal - new car doesn't conform to the expected type
}
