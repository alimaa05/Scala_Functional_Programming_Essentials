package lectures.partOneBasics

object ValuesVariableTypes extends App{

  val x: Int = 42
  println(x)
// if you use val the variable will be immutable
// the types of val is optional - compiler can infer types

  val aString: String = "hello"
  val anotherString = "goodbye"
// ; necessary if writing multiple expression on same line but its bad style

  val aBoolean: Boolean = true
  var aChar: Char = 'a'
  val anInt: Int = x
  val aShort: Short = 4613
  val aLong: Long = 568904424455662L
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  // variables
  var aVariable: Int = 4

  // can be reassigned

  aVariable = 5 // side effects - allow us to see what program is doing

}
