name := "mesos-dns-ui"
version := "0.1"
scalaVersion := "2.11.5"

enablePlugins(JavaAppPackaging)
enablePlugins(JDKPackagerPlugin)

maintainer := "Alvaro Nistal"
packageSummary := s"UI to show entries painting a graph for Mesos DNS"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.4.3",
  "io.spray" %%  "spray-can" % "1.3.2",
  "io.spray" %%  "spray-routing" % "1.3.2",
  "io.spray" %%  "spray-json" % "1.3.2",
  "io.spray" %%  "spray-client" % "1.3.2",
  "io.spray" %%  "spray-testkit" % "1.3.3" % "test",
  "org.json4s" %% "json4s-native" % "3.3.0",
  "org.slf4j" % "slf4j-api" % "1.7.21",
  "org.apache.httpcomponents" % "httpclient" % "4.5.2",
  "commons-io" % "commons-io" % "2.4"
)

lazy val app = (project in file(".")).
  settings(
    mainClass in assembly := Some("com.anistal.mesosdns.runners.MesosDNSRunner")
  )