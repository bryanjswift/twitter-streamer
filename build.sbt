organization := "com.streamer.twitter"

name := "twitter-streamer"

version := "1.0.4-SNAPSHOT"

scalaVersion := "2.9.1"

resolvers ++= Seq(
  "Twitter Repo" at "http://maven.twttr.com/",
  "Coda's Repo" at "http://repo.codahale.com/"
)

libraryDependencies ++= Seq(
  "com.codahale" %% "fig" % "1.1.7",
  "commons-httpclient" % "commons-httpclient" % "3.1",
  "org.slf4j" % "slf4j-api" % "1.6.1",
  "org.slf4j" % "slf4j-log4j12" % "1.6.1",
  "commons-logging" % "commons-logging" % "1.1",
  // Testing
  "junit" % "junit" % "4.10" % "test",
  "org.scalatest" %% "scalatest" % "1.7.1" % "test"
)
