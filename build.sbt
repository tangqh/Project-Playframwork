name := """play"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
 "postgresql" % "postgresql" % "9.1-901-1.jdbc4",
 "org.webjars" % "bootstrap" % "3.2.0",
  javaJdbc,
  javaEbean,
  cache,
  javaWs
)
