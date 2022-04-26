package lectures.partOneBasics

object CBNvsCBV extends App{

  def calledByValue(x: Long): Unit = { // used type Long bec time functions in Scala and on JVM return Longs
    println("by value: " + x)
    println("by value: " + x)

    // the exact value of this expression is computed before the function evaluates
    // and the same value is used in the function definition
  }


  def calledByName(x: => Long): Unit = {
    // arrow makes a big difference, it explains the difference between the two values printed
    // => arrow delays the evaluation of the expression passes as parameter and its used literally every time its used in the function definition
    println("by name: " + x)
    println("by name: " + x)

    // the expression is passed literally as is
    // the expression is evaluated every time, different times

    // this is useful in lazy streams and in things which might fail
  }
    calledByValue(System.nanoTime()) // both values are same
    calledByName(System.nanoTime()) // by name values are both different


  // creating a small, infinite recursive function

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

//  printFirst(infinite(), 34) this returns a stack overflow error

  printFirst(34, infinite())
  // the by name parameter delays the evaluation of the expression passed here until its used
  // here parameter y is not used, and 'infinite' is never evaluated and so the program doesn't crash
}
