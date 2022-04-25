package lectures.partOneBasics

import scala.annotation.tailrec

object Recursion extends App{
  def factorial(n: Int): Int = {
    if (n <=0) 1
  else { //else branch is a code block - value of code block is 'result'
      println("computing factorial of " + n + " - I first need factorial of " + (n-1)) // this will show the entire stack frame the JVM needs to compute our factorial of 10
      val result = n * factorial(n-1) // NOT TAIL RECURSIVE bec factorial recursion code doesn't occur as its last expression
      println("computed factorial of " + n) // once it figures out the base case, the call stack is freed with intermediate results

      result
    }
  }
  println(factorial(10))

  println("-----------------------------------")
  // in order to run a recursive function the JVM on top of which Scala runs, uses a call stack to keep partial returns
  // so it can get back to computing the desired result
  // each call of recursive function uses a stack frame

  // issue is JVM keeps all the calls on its internal stack which has limited memory
  // can cause stack overflow error - happens when the recursive depth is too big - crashes

  //-----------------------------------

  // defining another factorial - TAIL RECURSIVE

  def anotherFactorial(n: Int): BigInt = {
    // essentially the essence of the factorial
    @tailrec // adding this annotation tells the compiler that this function is meant to be tail recursive - if its not then compiler throws an error
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if (x < 1) accumulator // base case for the factorial too
      else factHelper(x - 1, x * accumulator) // TAIL RECURSION // KEY FOR TAIL RECURSION = use recursive call as the last expression on each code

    factHelper(n, 1)
  }

  println(anotherFactorial(5000)) // This overflows the integer representation

  println("-----------------------------------")
  /* how it works
    * anotherFactorial(10) = factHelper(10 ,1)
    * = factHelper(9, 10 * 1) - factHelper of 9 and 10, is 9 less than or equal to 1 = no so it repeats the else branch again
    * = factHelper(8, 9 * 10 * 1) - x - 1 is 8 bec the original parameter was 9 and accumulator is 10 * 1 and x is equal to 9
    * = factHelper(7, 8 * 9 * 10 * 1)
    * = ...
    * = factHelper(2, 3 * 4 * ... * 10 * 1) - 2 is not less than or equal to one - there will be one final recursive call with x minus one
    * = factHelper(1, 2 * 3 * 4 * ... * 10 * 1) - last call - factHelper of 1 and accumulator will go on the if branch bec 1 is less than or equal to 1
    * = 2 * 3 * 4 * ... * 10 * 1 - factHelper actually implements the factorial definition
   */

  // this way of writing the recursive function works with bigger numbers

  // this function works and above doesn't bec here we wrote factHelper as the last expression of its code path
  // this allows Scala to preserve the same stack frame and not use additional stack frames for recursive calls
  // here Scala doesn't need to save intermediate results to be used later
  // so when you evaluate this recursive call, the current stack frame is replaced with factHelper of something else without using extra stack memory
  // i.e. TAIL RECURSION
  // BUT in the one above, Scala needed a recursive call stack frame for each recursive call, so it can multiply it with a number then pass it back from the stack

  // try to make recursive methods tail recursive - that's how we can achieve he iteration vs recursion approach

  // how do you iterate when recursion is limited - instead if loops use TAIL RECURSION


  /* Exercises
    * 1. concatenate a String n times using tail recursion
    * 2. isPrime function that's tail recursive
    * 3. fibonacci function that's tail recursive
    * trick is to use accumulators to store intermediate results instead of calling the function recursively
    * need as many accumulators as you have recursive calls on your code path
   */

  // 1.
  @tailrec
  def aConcatenateTailRec(aString: String, n: Int, accumulator: String): String = //accumulator needs to have same return type as intended return type for the function
    if (n <= 0) accumulator
    // instead of returning base case i.e. empty string, will return accumulator
    else aConcatenateTailRec(aString, n-1, aString + accumulator)

    println(aConcatenateTailRec("hello", 3, " "))

  println("-----------------------------------")

  // 2.

  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailRec (t: Int, isStillPrime: Boolean): Boolean =
      if(!isStillPrime) false
      else if (t <= 1) true
    else isPrimeTailRec(t - 1, n % t != 0 && isStillPrime)

    isPrimeTailRec(n/2, true)
  }
    println(isPrime(2003))
    println(isPrime(629))

  println("-----------------------------------")
  // 3.

  def fibonacci (n: Int): Int = {
    def fibonacciTailRec(i: Int, last: Int, nextToLast: Int): Int =  // need to accumulators fibonacci n-1 and fibonacci n-2
      if (i >= n) last
      else fibonacciTailRec(i + 1, last + nextToLast, last)

    if(n <= 2) 1
    else fibonacciTailRec(2, 1, 1)
  }
  println(fibonacci(8))
}
