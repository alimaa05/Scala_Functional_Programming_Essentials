package lectures.part2oop

object Exceptions extends App{

// exceptions come from the java language and are JVM specific, no scala specific thing
  val x: String = null
//  println(x.length) this will crash with NPE

  // throwing exceptions

//  val aWeirdValue: String = throw new NullPointerException // an expression that throws an exception - crashes the program bec nothing to catch it
  // this is a valid variable

  // exceptions are instances of classes - NullPointerException is actually a class which is being instantiated and throwing an instance of null pointer exception

  // the property of class to be throwable is restricted by that class deriving from the throwable type

  // throwable classes extend the Throwable class

  // Exception and Error are the major Throwable subtypes
  // exceptions denote something that went wrong wit the program e.g. NPE
  // error knows something that happened wrong with the system e.g. stack overflow


  // catching exceptions

  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No int for you")
    else 42

  // guard against an exception from this method with a try catch expression
  val potentialFail = try {
    // code that might throw
    getInt(false)
  } catch {
    // catch all the exceptions you might have
    case e: RuntimeException => 42
  } finally {
    // code that will get executed no matter what
    // the finally block is optional
    // it doesn't influence the return type of this expression
    // use finally only for side effects e.g. logging something to a file
    println("finally")
  }
  println(potentialFail)

  // How to define your own exception
  // custom exception are classes and like other classes, they can have class parameters, methods, fields etc.
  class MyException extends Exception
  // can create a new exception
  val exception = new MyException

//  throw exception

  // ----------------------------------------------
  /*
  1. crash program with an 'OutOfMemoryError' - happens when you want to allocate more memory than the JVM has
  2. crash with StackOverflowError
  3. define a PocketCalculator
  a class with a few methods
  - adds two numbers add(x,y)
  - subtract(x,y)
  - multiply(x,y)
  - divide(x,y)

  these methods will throw a custom exception if something wrong happens
  - OverflowException if add(x,y) exceeds Int.MAX_VALUE
  - UnderflowException if subtract(x,y) exceeds Int.MIN_VALUE
  - MathCalculatorException for division by 0
   */

 // 1. OOM error
//  val array = Array.ofDim(Int.MaxValue)

  // 2. SO error
//  def infinate: Int = 1 + infinate
//  val noLimit = infinate

// 3.

  class OverflowExcpetion extends RuntimeException
  class UnderflowException extends RuntimeException

  object PocketCalculator {
    def add(x: Int, y: Int) = {
      val result = x+y
      if (x > 0 && y > 0 && result < 0) throw new OverflowExcpetion
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
      }

    def subtract(x: Int, y: Int) = {
      val result = x-y
      if (x > 0 && y < 0 && result < 0) throw new OverflowExcpetion
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

  }

}
