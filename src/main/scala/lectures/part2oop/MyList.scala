package lectures.part2oop

// MyList is an abstract class
abstract class MyList {
// abstract class that describes a list of integers

  // list will be singly linked list that holds integers and will have the following methods:
  // 1. method 'head' will return an int - first element of this list
  // 2. method 'tail' - remainder of the list
  // 3. method 'isEmpty' - returns boolean and 'is this list empty'
  // 4. method 'add'(Int) => receives integer, returns new list with this element added
  // 5. override a special method called 'toString' => returns string representation of the list

  // 6.
  // add these methods into subclasses or subtypes of the 'MyList' abstract class
  // first decide on method signature of each method
  // then implement them into their subtypes

  // ----------------------------------------------
  // 1, 2, 3, 4
  def head: Int
  def tail: MyList
  def isEmpty : Boolean
  def add(plus: Int): MyList

  // 5
  // define protected element - that prints the elements in order with space between them
   def printElement: String
  // polymorphic call
  override def toString: String = "[" + printElement + "]"


  // 3 - implement the following functions on MyList
  // deciding on the function signatures
//  def map[B](transformer: MyTransformer[A, B]) : MyList[B]
//  def flatMap[B](transformer: MyTransformer[A, MyList[B]]) : MyList[B]
//  def filter (predicate: MyPredicate[A]) : MyList[A]

}
// 6
// Extending the MyList abstract class by two subclasses
// an empty list and non-empty list

// objects can extend classes
case object EmptyList extends MyList {
  def head: Int = throw new NoSuchElementException
  def tail: MyList = throw new NoSuchElementException
  def isEmpty : Boolean = true  // there's not really and head and tail for this object

  def add(element: Int): MyList = new notEmpty(element, EmptyList)

  // the element as the head and the EmptyList object is the tail
  // add element with turn it into a non-empty list

   def printElement: String = ""

  // implementing the functions
//  def map[B](transformer: MyTransformer[Nothing, B]) : MyList[B] = Empty
//  def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]) : MyList[B] = Empty
//  def filter (predicate: MyPredicate[Nothing]) : MyList[Nothing] = Empty
}

// non-empty list
case class notEmpty (h : Int, t: MyList) extends MyList {
  // this passes two parameters
  def head: Int = h
  def tail: MyList = t
  def isEmpty : Boolean = false
  def add(element: Int): MyList = new notEmpty(element, this)
  def printElement: String = {
  if (t.isEmpty) "" + h
  else h + " " + t.printElement

//  def filter (predicate: MyPredicate[A]) : MyList[A] =
  }
}
// by using the keyword 'case' - made MyList more powerful - implemented equals and hashCode out of the box, so can use the list in collections too
// made MyList serialisable which makes it v powerful to use in distributed networks

// ----------------------------------------------
// 1
  trait MyPredicate[-T] {
    def test(element: T) : Boolean
  }

// 2
//  trait MyTransformer[-A,B] {
//    def transform[element: A] : B
//  }

// ----------------------------------------------
object ListTest extends App {
  val list = new notEmpty(1, new notEmpty(2,new notEmpty(3, EmptyList)))
  val clonedList = new notEmpty(1, new notEmpty(2,new notEmpty(3, EmptyList)))

  println(list.tail.head)
  println(list.add(4).head)
  println(list.isEmpty)

  println(list.toString)

  println(list == clonedList) // this returns true bec of the keyword 'case'
  // - if this wasn't used, would need to define a recursive equals method that would harder bec would need to compare all elements recursively
}

// ----------------------------------------------
/*
  * 1. Generic trait called MyPredicate[-T] will have a method called test[T]=> Boolean
        define MyPredicate with minus sign for T
        define it contravariant in the type T
        without this code wont compile
   * 2. Generic trait MyTransformer[-A,B] - takes two parameters and have a small method to convert a value of Type A into a value of type B
      every subclass of my transformer will have a diff implementation of that method
        define MyTransformer with minus sign for A
        define it contravariant in the type A
        without this code wont compile

      * with a method called transform(A) => B
  * 3. implement the following functions on MyList:
      - function called 'map' that takes some of 'MyTransformer'  => MyList and returns a new MyList
      - filter(predicate) => myList
      - flatMap (transformer from A to MyList of [B] => MyList[B]


      * e.g. a class that extends MyPredicate[T]
      * class EvenPredicate extends MyPredicate[Int]

      * if MyPredicate is implemented properly in MyTransformer then map, filter, flatmap would work as follows
      * e.g. [1,2,3].map(n * 2) = [2,4,6]
      * e.g. [1,2,3,4].filter(n%2) = [2,4]
      * e.g. [1,2,3].flatMap(n => [n, n+1] => [1,2,2,3,3,4]
 */