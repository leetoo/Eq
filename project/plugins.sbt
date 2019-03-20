logLevel := Level.Warn


addSbtPlugin("com.lucidchart" % "sbt-scalafmt" % "1.14")

addSbtPlugin("io.get-coursier" % "sbt-coursier" % "1.0.0")

addSbtPlugin("org.lyranthe.sbt" % "partial-unification" % "1.1.2")

resolvers += Resolver.sonatypeRepo("releases")
addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)

