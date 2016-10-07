organization := "com.example"

version := "0.1"

scalaVersion := "2.11.6"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

resolvers += "repo.novus rels" at "http://repo.novus.com/releases/"

libraryDependencies ++= {
  val akkaV = "2.3.9"
  val sprayV = "1.3.3"
  val sprayJ = "1.3.2"
  Seq(
    "io.spray" %% "spray-can" % sprayV,
    "io.spray" %% "spray-routing" % sprayV,
    "io.spray" %% "spray-json" % sprayJ,

    "com.escalatesoft.subcut" %% "subcut" % "2.1",
    "org.mongodb" %% "casbah" % "2.8.1",
    "com.github.salat" %% "salat" % "1.10.0",
    "io.spray" %% "spray-testkit" % sprayV % "test",

    "com.typesafe.akka" %% "akka-actor" % akkaV,
    "com.typesafe.scala-logging" %% "scala-logging" % "3.5.0",
    "org.slf4j"     % "slf4j-log4j12" % "1.7.2",

    "com.typesafe.akka" %% "akka-testkit" % akkaV % "test",
    "org.specs2" %% "specs2-core" % "2.3.11" % "test"
  )
}

Revolver.settings
