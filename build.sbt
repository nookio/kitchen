name := """kitchen"""

version := "1.0-SNAPSHOT"

lazy val myProject = (project in file("."))
  .enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.11.7"

resolvers += "OSChina Maven Repository" at "http://maven.aliyun.com/nexus/content/repositories/central/"

resolvers += Resolver.url("github repo for html5tags", url("http://loicdescotte.github.io/Play2-HTML5Tags/releases/"))(Resolver.ivyStylePatterns)

// https://mvnrepository.com/artifact/org.apache.poi/poi
libraryDependencies += "org.apache.poi" % "poi" % "3.12"
// https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml
libraryDependencies += "org.apache.poi" % "poi-ooxml" % "3.12"







libraryDependencies ++= Seq(
  "mysql" % "mysql-connector-java" % "5.1.18",
  "com.loicdescotte.coffeebean" %% "html5tags" % "1.2.2",
  "com.alibaba" % "fastjson" % "1.2.5",

  javaJdbc,
  cache,
  javaWs
)
