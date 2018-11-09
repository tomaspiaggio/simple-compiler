import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.7",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "trabajo-practico",
    libraryDependencies += scalaTest % Test,
    // https://mvnrepository.com/artifact/de.jflex/jflex
    libraryDependencies += "de.jflex" % "jflex" % "1.7.0"

)
