name := "Euchre"

version := "0.1.0"

scalaVersion := "2.12.4"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.4" % "test"

libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.13.4" % "test"

resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"

addSbtPlugin("com.artima.supersafe" % "sbtplugin" % "1.1.3")

scalastyleConfig := file("src/test/resources/scalastyle-config.xml")

scalastyleFailOnError := true

scalastyleFailOnWarning := true

coverageEnabled := true

coverageMinimum := 100

coverageFailOnMinimum := true

coverageHighlighting := true
