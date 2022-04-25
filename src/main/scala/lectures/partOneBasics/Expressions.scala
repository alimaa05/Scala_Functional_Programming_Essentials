package lectures.partOneBasics

object Expressions extends App{

  val x = 1 + 2 // expression - evaluated to a value
  println(x)

  // relational operations
  println(1 == x)
  // == != > >= < <=

  // boolean operators for logic
  // logic negation - unary operator
  // you can have logical and in logical operators
  // or operators that are binary - these act on 2 booleans and return a boolean
  println(!(1==x))

  var aVariable = 2
  aVariable += 3 // also works with -= *= /= only works with variables --> these are side effects

  // changing a variable is called side effects

  // Statement vs Expression
  // statement - tell the computer to do something
  // expression - something that has a value  and or a type

  // scala and functional programming think in terms of expressions - every line of code computes a value
  // example: if expression

  val aCondition = true
  val aConditionedValue = if (aCondition) 5 else 3 // if expression returns a value
  println(aConditionedValue)

  // there's loops in scala but its discouraged to use them
  // they don't return anything meaningful and only execute side effects

  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  } // never write loops to iterate - in scala we take a different approach

  // while and looping is specific to imperative programming

  // scala forces everything to be an expression
  // i.e. operations, calling functions, if expressions, reassigning a variable - just doesn't return anything meaningful

  val aWeirdValue = (aVariable = 3) // unit is V special type  - its same as void in other languages - it doesn't return anything meaningful
  println(aWeirdValue) // empty parenthesis () - its the only value unit type can hold

  /* side effects examples:
    * printing something to console
    * whiles
    * reassigning of vars
    * these are expressions returning unit
   */

  // Code Blocks - special kind of expression bec they have special properties

  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z> 2) "hello" else "goodbye"
  }
  /* this between curly braces is code block
    * write code between {}
    * can define values
    * can write expressions
    * code block is an expression
    * value of the block is the value of its last expression
    *
    * code blocks can have their own definition of values and variables
    * everything inside stays visible within the code block
   */

  // Questions

  // difference between "hello world" vs println("hello world")
  // former is a value of type string
  // latter is an expression which is a side effect with type unit acc prints to the console

  val someValue = {
    2 < 3
  } // code block with value of type boolean

  val someOtherValue = {
    if (someValue) 239 else 986
    42
  } // code block value of type Int

}
