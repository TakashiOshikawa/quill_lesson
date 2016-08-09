package com.lesson

import io.getquill._
import io.getquill.JdbcContext
import io.getquill.MySQLDialect
import io.getquill.SnakeCase


case class designers(id: Int, name: String, email: String)

class MyContect extends JdbcContext[MySQLDialect, SnakeCase]("ctx")

object Main {

  def main(args: Array[String]): Unit = {
    println(Designer.list)
  }

}

object schema extends MyContect {

  val findDesigner = quote {query[designers].filter(_.name == "kojiro")}

  val designersdb = quote {
    query[designers].schema(
      _.entity("designers")
        .generated(_.id))
  }
}

object Designer {
  import schema._

  def list: Seq[designers] = run(designersdb.sortBy(_.name))

}
