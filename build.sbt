name := "slascala-emoji-client"

version := "0.0.1"

scalaVersion := "2.12.1"

libraryDependencies ++= Seq(
  "org.skinny-framework" %% "skinny-http-client" % "2.3.3",
  "org.slf4j"            %  "slf4j-api"          % "1.7.21",
  "org.jsoup"            %  "jsoup"              % "1.10.2",
  "org.scalatest"        %% "scalatest"          % "3.0.1" % "test"
)