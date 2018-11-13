import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.matedis",
      scalaVersion := "2.12.7",
      version := "0.1.0-SNAPSHOT"
    )),
    name := "trabajo-practico",
    libraryDependencies += scalaTest % Test,
    // https://mvnrepository.com/artifact/de.jflex/jflex
//    libraryDependencies += "de.jflex" % "jflex" % "1.7.0",

    libraryDependencies += "java_cup" % "java_cup" % "11b" from "file:////Users/tomaspiaggio/Documents/Austral/Current/matedis/trabajo-practico/libs/java-cup-11b-runtime.jar"
  )

mainClass in (Compile, run) := Some("Main")