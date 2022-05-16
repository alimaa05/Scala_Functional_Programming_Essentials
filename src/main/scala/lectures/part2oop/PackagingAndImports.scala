package lectures.part2oop

// imports will be up here
// if your important from the same package it will be something like this
// import playground. (PrinceCharming, Cinderella)

// use ._ if you want to import all the classes - but only do this if you really need to
// using => to rename a class if you need to import more than one class with the same name

// these are two diff dates

import java.util.Date
import java.sql.{Date => SqlDate}


object PackagingAndImports extends App {

  // packages - a load of definitions grouped under the same name usually matches directory structure

  // package members are accessible by their simple name
  val writer = new Writer("Alimaa", "Hashim", 2000)

  // if you're not in the proper package you need to import the package
  // if you don't import then you need to write the fully qualified class name, so where its located

  // packages are in hierarchy
  // matching folder structure

  // PACKAGE OBJECT
  // originated from the problem that sometimes we want to write methods or constants outside of everything else
  // we can now only write classes and traits and objects and can only access values or method or constants
  // BUT we may need some universal constants or universal method that reside outside classes so we don't need to resort to classes to access them

// using the import dates
// compiler will think your referring to the first import i.e. the java util Date
// if you require both of these - you can either use the full qualified names
// or rename one of the classes - i.e. aliasing

    val date = new Date
    val sqlDate = new SqlDate(2010,5,3)

  // DEFAULT IMPORTS
  // packages that are automatically imported without intentional import from your side 

}
