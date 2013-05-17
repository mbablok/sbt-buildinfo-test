import sbt._
import Keys._
import play.Project._
import sbtbuildinfo.Plugin._

object ApplicationBuild extends Build {

  val appName         = "sbt-buildinfo-test"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
  )


  val main = play.Project(appName, appVersion, appDependencies,
      settings = Defaults.defaultSettings ++ buildInfoSettings
    ).settings(
      sourceGenerators in Compile <+= buildInfo,
      buildInfoKeys := Seq[BuildInfoKey](name, version, scalaVersion, sbtVersion),
      buildInfoPackage := "hello"
    )

}
