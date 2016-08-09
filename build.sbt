organization  := "com.lesson"

lazy val root = (project in file(".")).
  settings(
    name := "quill_lesson",
    version := "1.0",
    scalaVersion := "2.11.7",
    libraryDependencies ++= dervy
  )



lazy val dervy = {
  Seq(
    "mysql" % "mysql-connector-java" % "5.1.38",
    "io.getquill" %% "quill-jdbc" % "0.8.0",
    "com.zaxxer" % "HikariCP" % "2.4.3",
    "com.typesafe" % "config" % "1.3.0"
  )
}