package lectures.part2oop

// MyList is an abstract class
abstract class MyList {
// abstract class that describes a list of integers

  // list will be singly linked list that holds integers and will have the following methods:
  // method 'head' will return an int - first element of this list
  // method 'tail' - remainder of the list
  // method 'isEmpty' - returns boolean and 'is this list empty'
  // method 'add'(Int) => receives integer, returns new list with this element added
  // override a special method called 'toString' => returns string representation of the list

  // add these methods into subclasses or subtypes of the 'MyList' abstract class
  // first decide on method signature of each method
  // then implement them into their subtypes

  def head: Int
  def tail: MyList
  def isEmpty : Boolean
  def add(plus: Int): MyList

  // define protected element - that prints the elements in order with space between them
   def printElement: String

  // polymorphic call
  override def toString: String = "[" + printElement + "]"

}

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
}

// non-empty list
case class notEmpty (h : Int, t: MyList) extends MyList {
  // this passes two parameters
  def head: Int = h
  def tail: MyList = t
  def isEmpty : Boolean = false
  def add(element: Int): MyList = new notEmpty(element, this)
  def printElement: String =
  if (t.isEmpty) "" + h
  else h + " " + t.printElement
}
// by using the keyword 'case' - made MyList more powerful - implemented equals and hashCode out of the box, so can use the list in collections too
// made MyList serialisable which makes it v powerful to use in distributed networks

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
