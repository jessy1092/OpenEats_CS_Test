import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {
    val appName         = "openeats"
    val appVersion      = "1.0"

    val appDependencies = Seq(
    javaCore,
	javaJdbc,
	javaJpa,
    "org.hibernate" % "hibernate-entitymanager" % "4.2.8.Final",
    "securesocial" %% "securesocial" % "master-SNAPSHOT"
	)
	val main = play.Project(appName, appVersion, appDependencies).settings(
	  resolvers += Resolver.url("sbt-plugin-snapshots", new URL("http://repo.scala-sbt.org/scalasbt/sbt-plugin-snapshots/"))(Resolver.ivyStylePatterns)
	)
}
