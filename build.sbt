name := "UT-IT-Assignment"

version := "0.1"

scalaVersion := "2.13.4"

val scalatest= "org.scalatest" %% "scalatest" % "3.2.2" % "test"
val mockito= "org.mockito" %% "mockito-scala" % "1.5.12" % "test"
lazy val Q1_and_Q2 = project.in(file("Q1_and_Q2")).settings {
  libraryDependencies += scalatest
}
lazy val Q3 = project.in(file("Q3")).settings(
  libraryDependencies ++=Seq(scalatest, mockito)
)

lazy val root = project.in(file(".")).aggregate(Q1_and_Q2,Q3)
