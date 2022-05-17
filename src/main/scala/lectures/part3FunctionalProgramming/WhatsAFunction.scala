package lectures.part3FunctionalProgramming

object WhatsAFunction extends App{

  // use functions as first class elements
  // oop - everything is an object i.e. its an instance of some type of class
  // so the only way to simulate functional programming was to ue classes and instances of those classes

  // function types = Function[A,B]

  // function types - Function2[A,B,R] === (A,B) => R

  // ALL SCALA FUNCTIONS ARE OBJECTS - INSTANCES OF CLASSES DERIVING FROM FUNCTION ONE, TWO ETC.

  def concat: (String, String) => String = new Function[String, String,String {
    override def apply()
  }]
}
