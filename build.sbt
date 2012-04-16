name := "sbt-hello"

version := "0.1"

seq(slickSettings: _*)

seq(oldLwjglSettings: _*)

scalaVersion := "2.9.1"

resolvers += "Scala-Tools Maven2 Snapshots Repository" at "http://scala-tools.org/repo-releases"

//resolvers += "Slick Maven Repository" at "http://slick.cokeandcode.com/mavenrepo"

//resolvers += "lwjgl" at "http://adterrasperaspera.com/lwjgl"

resolvers += "Scage Maven Repo" at "http://scage.googlecode.com/svn/maven-repository"

//resolvers += "Some maven repo I don't know" at "http://java.freehep.org/maven2"

//resolvers += "Another repo I don't give a shit..." at "http://b2s-repo.googlecode.com/svn/trunk/mvn-repo"

libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-library" % "2.9.1",
  "junit" % "junit" % "3.8.1",
  "su.msk.dunno" % "scage" % "0.9-SNAPSHOT"
)

// reduce the maximum number of errors shown by the Scala compiler
maxErrors := 20

// increase the time between polling for file changes when using continuous execution
pollInterval := 1000

// append several options to the list of options passed to the Java compiler
javacOptions ++= Seq("-source", "1.6", "-target", "1.6")

// append -deprecation to the options passed to the Scala compiler
scalacOptions ++= Seq("-deprecation", "-optimise")

// define the statements initially evaluated when entering 'console', 'console-quick', or 'console-project'
initialCommands := """
  import System.{currentTimeMillis => now}
  def time[T](f: => T): T = {
    val start = now
    try { f } finally { println("Elapsed: " + (now - start)/1000.0 + " s") }
  }
"""

mainClass := Some("net.scageprojects.sbthello.SbtTestApp")

// set the prompt (for this build) to include the project id.
shellPrompt in ThisBuild := { state => Project.extract(state).currentRef.project + "> " }

// set the prompt (for the current project) to include the username
shellPrompt := { state => System.getProperty("user.name") + "> " }

// fork a new JVM for 'run' and 'test:run'
fork := true

// fork a new JVM for 'test:run', but not 'run'
fork in Test := true

// add a JVM option to use when forking a JVM for 'run'
javaOptions += "-Xmx1G"

// only show 10 lines of stack traces
traceLevel := 10


