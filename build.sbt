import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.7",
      version := "0.1.0-SNAPSHOT"
    )),
    name := "trabajo-practico",
    libraryDependencies += scalaTest % Test,
    // https://mvnrepository.com/artifact/de.jflex/jflex
    libraryDependencies += "de.Sentence.jflex" % "jflex" % "1.7.0",
    // https://mvnrepository.com/artifact/java_cup/java_cup
    libraryDependencies += "java_cup" % "java_cup" % "0.9e"
  )