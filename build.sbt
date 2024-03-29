name := """play"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
 "org.postgresql" % "postgresql" % "9.2-1003-jdbc4",
 "org.webjars" % "bootstrap" % "3.2.0",
  javaJdbc,
  javaEbean,
  cache,
  javaWs
)
