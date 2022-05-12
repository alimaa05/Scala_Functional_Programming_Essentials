package lectures.part2oop

object Enums extends Enumeration {



//   Scala program Printing particular element of the enumeration

//   Creating enumeration
    type Enums = Value

    // Assigning values
    val first = Value("Thriller")
    val second = Value("Horror")
    val third = Value("Comedy")
    val fourth = Value("Romance")

//  Changing default IDs of values
//  The values are printed in the order of the ID set by us
//  These values of IDs can be any integer .These IDs need not be in any particular order
  // e.g.
// Assigning Values
//  val first = Value(0, "Thriller")
//  val second = Value(-1, "Horror")
//  val third = Value(-3, "Comedy")
//  val fourth = Value(4, "Romance")

    // Main method
    def main(args: Array[String]) {
      println(s"The third value = ${Enums.third}")
      println(s"ID of third = ${Enums.third.id}")

      Enums.values.foreach
      {
        // Matching values in Enumeration
        case d if ( d == Enums.third ) =>
          println(s"Favourite type of Movie = $d")
        case _ => None
      }
    }
  }


//Important points of enum :
//  In Scala, there is no enum keyword unlike Java or C.
//  Scala provides an Enumeration class which we can extend in order to create our enumerations.
//  Every Enumeration constant represents an object of type Enumeration.
//  Enumeration values are defined as val members of the evaluation.
//  When we extended the Enumeration class, a lot of functions get inherited. ID is one among the them.
//  We can iterate the members.

//------------------------------------




// ------------------------------------

// This doesn't work
//  enum Permissins({
// will have a bunch of instances we create in the class or in here in the body
// the way we create the only possible instances of this type is with a keyword 'case'
//        case READ, WRITE, EXECUTE, NONE
//      })
//  val somePermissions: Permissions = Permissions.READ
// are a data type