package lectures.partOneBasics

object Functions extends App {

  // keyword defining a function = def
  // in parenthesis the parameters - which has a name and type
  // : String = the return type
  def aFunction(a: String, b: Int): String = {

    a + " " + b
  }
  // call the function by naming it and in parenthesis pass values for parameters
  println(aFunction("hello", 3))

  // calling a function is also an expression

  // parameterless functions can be called with just their names
  def aParameterlessFunction(): Int = 42

  println(aParameterlessFunction())
  println(aParameterlessFunction)

  println("---------------------------------")

  // use recursive functions instead of loops
  // this is a recursive function
  // recursive functions need to have a return type specified bec the compiler is unable to identify this on its own
  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }

  println(aRepeatedFunction("hello", 3))

  "---------------------------------"

  // you can use Unite as return type so define a function as only executing side effects
  // we need functions with side effects if we want something that has to do with computation itself
  // e.g. printing something to console, displaying something on screen, logging something, writing to file etc.
  def aFunctionWithSideEffect(aString: String): Unit = println(aString)

  // in code blocks you can also define auxiliary functions inside
  def aBigFunction(n: Int): Int = {
    // can define auxiliary function inside
    def aSmallerFunction(a: Int, b: Int): Int = a + b
    // you can use the function that you define in the code block to determine the return type of the big function you implement

    // call a smaller function
    // this is the return expression of the implementation of a big function
    aSmallerFunction(n, n - 1)
  }
    // exercise
    // 1. a greeting function - takes two parameters (name, age) -> "Hi, my name is ___ and I am __ years old"
    // 2. factorial function i.e. a math function that computes the product of all numbers up to a given number that you pass in as parameters 1 * 2 * 3 * ... * n (recursive function)
    /* 3. fibonacci function - a stream of numbers
      * f(1) = 1
      * f(2) = 1
      * f(n) = f(n -1) + f(n - 2)
      * a stream of numbers that explodes exponentially
     */
    // 4. a function that tests if a number is prime

    println("---------------------------------")

    def greetingFunction(name: String, age: Int): String =
      "Hi my name is " + name + ", I am " + age + " years old"

    println(greetingFunction("Alimaa", 21))

    println("---------------------------------")
  // recursive function
    def factorialFunction(n: Int): Int = {
      if (n <= 0) 1
      else n * factorialFunction(n-1)
    }
    println(factorialFunction(5))

    println("---------------------------------")
  // recursive function
  def fibonacci (n: Int): Int =
    if (n <= 2) 1
    else fibonacci(n-1) + fibonacci(n-2)

  // fibonacci numbers are 1 1two fibonacci numbers and then fibonacci numbers are the sum of the last two
  // 1 + 1 = 2, 2 + 1 = 3, 2 + 3 = 5, 5 + 8 = 13 etc
  // 1 1 2 3 5 8 13 21
  println(fibonacci(8))

  println("---------------------------------")

  // this needs an auxiliary function
  def isPrime(n: Int): Boolean = {

  }


}

