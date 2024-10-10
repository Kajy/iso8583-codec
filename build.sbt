
ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.15"

lazy val `root` = (project in file("."))
  .settings(
    name := "iso8583-codec"
  )


libraryDependencies ++= Seq(
  "org.scodec" %% "scodec-cats" % "1.2.0",
  "org.scodec" %% "scodec-bits" % "1.2.0",
  "org.typelevel" %% "log4cats-slf4j" % "2.7.0",
  "ch.qos.logback" % "logback-classic" % "1.5.8",
  "com.beachape" %% "enumeratum" % "1.7.4",
  "com.neovisionaries" % "nv-i18n" % "1.29",
  "org.typelevel" %% "cats-effect-testing-scalatest" % "1.5.0" % Test
)
