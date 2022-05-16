package lectures

package object part2oop {

  // package objects can only be one per package

  def sayHello: Unit = println("Hello, Scala") // this would be accessible throughout the entire package
  // rarely used in practice
}
