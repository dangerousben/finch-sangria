organization := "com.redbubble"

lazy val buildSettings = Seq(
  name := "finch-sangria",
  scalaVersion := "2.12.6"
)

enablePlugins(GitVersioning, GitBranchPrompt)

git.useGitDescribe := true

bintrayOrganization := Some("redbubble")

bintrayRepository := "open-source"

bintrayPackageLabels := Seq("finch", "sangria", "graphql")

licenses += ("BSD New", url("https://opensource.org/licenses/BSD-3-Clause"))

scalacOptions ++= Seq(
  "-unchecked",
  "-deprecation",
  "-Xlint",
  "-encoding", "UTF-8",
  "-feature",
  "-language:existentials",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-language:reflectiveCalls",
  "-unchecked",
  "-Yno-adapted-args",
  "-Ywarn-dead-code",
  "-Ywarn-numeric-widen",
  "-Xfuture",
  "-Xlint",
  //"-Yno-predef",
  //"-Ywarn-unused-import", // gives false positives
  "-Xfatal-warnings",
  "-Ywarn-value-discard",
  "-Ypartial-unification"
)

scalacOptions in Test ++= Seq("-Yrangepos")

resolvers ++= Seq(
  Resolver.jcenterRepo,
  Resolver.sonatypeRepo("releases"),
  Resolver.sonatypeRepo("snapshots"),
  Resolver.bintrayRepo("redbubble", "open-source"),
  "Twitter" at "http://maven.twttr.com"
)

lazy val rbUtilsVersion = "0.2.11"
lazy val catsVersion = "1.1.0"
lazy val mouseVersion = "0.17"
lazy val circeVersion = "0.9.3"
lazy val finchVersion = "0.19.0"
lazy val sangriaVersion = "1.4.1"
lazy val sangriaCirceVersion = "1.2.1"
lazy val specsVersion = "4.2.0"
lazy val slf4jVersion = "1.7.25"

libraryDependencies ++= Seq(
  "com.redbubble" %% "rb-scala-utils" % rbUtilsVersion,
  "org.typelevel" %% "cats-core" % catsVersion,
  "org.typelevel" %% "mouse" % mouseVersion,
  "io.circe" %% "circe-core" % circeVersion,
  "io.circe" %% "circe-generic" % circeVersion,
  "io.circe" %% "circe-parser" % circeVersion,
  "com.github.finagle" %% "finch-core" % finchVersion,
  "com.github.finagle" %% "finch-circe" % finchVersion,
  "org.sangria-graphql" %% "sangria" % sangriaVersion,
  "org.sangria-graphql" %% "sangria-relay" % sangriaVersion,
  "org.sangria-graphql" %% "sangria-circe" % sangriaCirceVersion,
  "org.slf4j" % "slf4j-api" % slf4jVersion,
  "org.specs2" %% "specs2-core" % specsVersion % "test",
  "org.specs2" %% "specs2-scalacheck" % specsVersion % "test"
)
