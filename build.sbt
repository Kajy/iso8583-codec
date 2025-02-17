ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.15"

lazy val `root` = (project in file("."))
  .settings(
    organization := "io.kajy",
    name         := "iso8583-codec"
  )

libraryDependencies ++= Seq(
  "org.scodec"        %% "scodec-cats"                   % "1.2.0",
  "org.scodec"        %% "scodec-bits"                   % "1.2.0",
  "org.typelevel"     %% "log4cats-slf4j"                % "2.7.0",
  "ch.qos.logback"     % "logback-classic"               % "1.5.8",
  "com.beachape"      %% "enumeratum"                    % "1.7.4",
  "com.neovisionaries" % "nv-i18n"                       % "1.29",
  "org.typelevel"     %% "cats-effect-testing-scalatest" % "1.5.0" % Test
)

val scalacOptionsFor213 =
  Seq(
    "-Xsource:3", // activate warnings for Scala 3 migration
    "-encoding",
    "utf8",
    "-deprecation:false",            // Emit warning and location for usages of deprecated APIs.
    "-explaintypes",                 // Explain type errors in more detail.
    "-feature",                      // Emit warning and location for usages of features that should be imported explicitly.
    "-language:existentials",        // Existential types (besides wildcard types) can be written and inferred
    "-language:experimental.macros", // Allow macro definition (besides implementation and application)
    "-language:higherKinds",         // Allow higher-kinded types
    "-language:implicitConversions", // Allow definition of implicit functions called views
    "-language:postfixOps",
    "-unchecked",                                // Enable additional warnings where generated code depends on assumptions.
    "-Xcheckinit",                               // Wrap field accessors to throw an exception on uninitialized access.
    "-Xfatal-warnings",                          // Fail the compilation if there are any warnings.
    "-Xlint:adapted-args",                       // Warn if an argument list is modified to match the receiver.
    "-Xlint:constant",                           // Evaluation of a constant arithmetic expression results in an error.
    "-Xlint:delayedinit-select",                 // Selecting member of DelayedInit.
    "-Xlint:doc-detached",                       // A Scaladoc comment appears to be detached from its element.
    "-Xlint:inaccessible",                       // Warn about inaccessible types in method signatures.
    "-Xlint:infer-any",                          // Warn when a type argument is inferred to be `Any`.
    "-Xlint:missing-interpolator",               // A string literal appears to be missing an interpolator id.
    "-Xlint:nullary-unit",                       // Warn when nullary methods return Unit.
    "-Xlint:option-implicit",                    // Option.apply used implicit view.
    "-Xlint:package-object-classes",             // Class or object defined in package object.
    "-Xlint:poly-implicit-overload",             // Parameterized overloaded implicit methods are not visible as view bounds.
    "-Xlint:private-shadow",                     // A private field (or class parameter) shadows a superclass field.
    "-Xlint:stars-align",                        // Pattern sequence wildcard must align with sequence component.
    "-Xlint:type-parameter-shadow",              // A local type parameter shadows a type already in scope.
    "-Ywarn-dead-code",                          // Warn when dead code is identified.
    "-Ywarn-extra-implicit",                     // Warn when more than one implicit parameter section is defined.
    "-Ywarn-numeric-widen",                      // Warn when numerics are widened.
    "-Ywarn-unused:implicits",                   // Warn if an implicit parameter is unused.
    "-Ywarn-unused:imports",                     // Warn if an import selector is not referenced.
    "-Ywarn-unused:locals",                      // Warn if a local definition is unused.
    "-Ywarn-unused:params",                      // Warn if a value parameter is unused.
    "-Ywarn-unused:patvars",                     // Warn if a variable bound in a pattern is unused.
    "-Ywarn-unused:privates",                    // Warn if a private member is unused.
    "-Ywarn-value-discard",                      // Warn when non-Unit expression results are unused.
    "-Ycache-plugin-class-loader:last-modified", // Enables caching of classloaders for compiler plugins
    "-Ymacro-annotations",
    "-Ycache-macro-class-loader:last-modified",      // and macro definitions. This can lead to performance improvements.
    "-Wconf:msg=While parsing annotations in:silent" // remove warning from provided lib
  )

scalacOptions ++= scalacOptionsFor213
