resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += Resolver.file("ivy2-local", new File(Path.userHome.absolutePath + "/.ivy2/local"))(Resolver.ivyStylePatterns)

addSbtPlugin("play" % "sbt-plugin" % "2.1.1")

name := "play2-scalate-plugin"

organization := "net.kindleit"

version := "0.1-SNAPSHOT"

description := "Play2 plugin that integrates Scalate with PlayFramework"

scalaVersion := "2.9.2"

sbtVersion := "0.12"

sbtPlugin := true

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { x => false }

pomExtra := (
  <url>https://github.com/kryptt/play2-scalate-plugin</url>
  <licenses>
  <license>
    <name>Apache 2</name>
    <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
    <distribution>repo</distribution>
  </license>
  </licenses>
    <scm>
    <url>git@github.com:kryptt/play2-scalate-plugin</url>
    <connection>scm:git:git@github.com:kryptt/play2-scalate-plugin</connection>
  </scm>
  <developers>
    <developer>
      <id>kryptt</id>
      <name>Rodolfo Hansen</name>
      <url>http://hobbes-log.blogspot.com</url>
    </developer>
  </developers>
)

publishTo <<= version { (v) =>
  if (v.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/")
  else
    Some("releases" at "https://oss.sonatype.org/service/local/staging/deploy/maven2/")
}

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")