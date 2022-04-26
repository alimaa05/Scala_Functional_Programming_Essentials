package lectures.partOneBasics

object StringOps extends App{

  val str: String = "Hello, I am learning Scala"

  // some standard string operations
  // these are all java functions available in scala
  println(str.charAt(2))
  println(str.substring(7, 11)) // inclusive, exclusive
  println(str.split(" ").toList) // slit the string into multiple pieces by the spaces, use .toList to turn the non-readable code to readable code
  println(str.startsWith("Hello")) // this function returns true or false
  println(str.replace(" ", "-")) // replaces the spaces with dashes
  println(str.toUpperCase())
  println(str.length)

  // scala also has it own utilities

  val numberString = "45" // can convert it into an int
  val number = numberString.toInt

  // Concatenation and prepend (prepending and upending)

  // prepending and appending operators are Scala specific
  println('a' +: numberString :+ 'z')
  // +: means your prepending the character 'a' to numberString
  // :+ means your appending the character 'z' to numberString

  // reverse
  println(str.reverse)

  // list like functions
  println(str.take(2))


  //. Scala-specific: String interpolators

  // s-interpolators
  val name = "David "
  val age = 12
  val greeting = s"Hello, my name is $name and I am $age years old"
  // adding s and start outside " "
  // and then $ before the variable name allows you to inject the value within the string
  // $name and $age are expanded within the s interpolated string

  // s-interpolated strings can also evaluate complex expressions
  val anotherGreeting = s"Hello, my name is $name and I will be turning ${age + 1} years old" // using $ curly braces to hold anything we want
  println(anotherGreeting)

  // F-interpolated strings
  // these act as s interpolator (can expand values or complex expressions inside) BUT can also receive printf like formats

  val speed = 1.2f
  val myth = f"$name can eat $speed%2.2f burgers per minute"
  // f before the quote
  // then % 2.2f this is a printf like format for displaying this value, which means two characters total minimum and 2 decimal precision

  println(myth)
  // prints David can eat 1.20 burgers per minute - although speed is define as 1.2, the format forces the floats to be displayed at 1.20 with enough precision

  // F-interpolated strings can also check for type correctness in the values that they expand

  // Raw-interpolator
  // works the same as the s-interpolator
  // BUT has the property to print characters literally
  // e.g.
  println(raw"This is a \n newline") // printed literally

  val escaped = "This is a \n newline"
  println(raw"$escaped") // newline is escaped and text prints on two lines
  // so raw-interpolator string, ignore escaped characters inside raw character in the string, else injected variables do get escaped

}
