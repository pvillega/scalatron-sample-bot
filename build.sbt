name := "scalatron-sample-bot"

version := "1.0"

scalaVersion := "2.11.7"

assemblyJarName in assembly := "ScalatronBot.jar"

resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"

libraryDependencies ++= Seq(
  "org.typelevel" %% "cats" % "0.4.1",
  "org.scalactic" %% "scalactic" % "2.2.6",
  "org.scalatest" %% "scalatest" % "2.2.6" % "test"
)