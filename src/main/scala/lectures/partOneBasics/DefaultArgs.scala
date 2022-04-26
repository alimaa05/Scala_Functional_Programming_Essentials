package lectures.partOneBasics

object DefaultArgs extends App{

  // tail recursive factorial

  // the idea with tail recursive factorial written like this is that
  // only useful use cases of the tail recursive factorial function we wrote earlier is to start with accumulator equals one

  // in general if you want the factorial of anything, you can call recursive factorial with that number and 1
  // accumulator basically starts up with 1 every single time
  // in some cases we create functions that will be called with the same parameter 99% of the time

  def trFactorial(n: Int, accumulator: Int = 1): Int =
  // scala allows us to pass default values for some parameters that we don't really want to show every single time
  // its done by specifying a default value at the parameter level i.e. if you don't pass through the accumulator value then its implied that its 1
    if (n <= 1) accumulator
    else trFactorial(n-1, n * accumulator)


  // if you want factorial of 10, you always call tail recursive factorial with 10 and 1
  //val fact10 = trFactorial(10, 1)


  val fact10 = trFactorial(10,2)
  // can still pass any parameter even though the default value for accumulator was specified
  // here the default value would be overwritten

  // passing default arguments is a popular feature in other languages as well like python and javaScript
  // BUT passing default values also has a set of challenges

  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = println("saving picture") // setting default values
  savePicture(width =800)
  // leading values, if they have default values, they can't really be admitted bec it would confuse the compiler
  // giving each value a default value
  // but even when setting default values for them all, if you put a value in the parameter, the compiler doesn't know which parameter this value stands for

  /* two solutions for the issue above
    * 1. pass in every leading argument
    * 2. name the arguments (would mean you're able to pass in the arguments in different orders
   */

  savePicture(height = 600, width = 400, format = "bmp") // still works despite being in diff order bec there is clarity on which parameter has which value



}
