package com.db.impl

import com.db.Db
import com.escalatesoft.subcut.inject.{BindingModule, Injectable}
import com.mongodb.casbah.MongoClient

/**
 * Created by roshane on 10/1/16.
 */
class DefaultDb(implicit val bindingModule: BindingModule) extends Db with Injectable {

  val mongoPort = inject[Int]("mongo.port")
  val mongoHost = inject[String]("mongo.host")
  val mongoDBname = inject[String]("mongo.dbname")


  val mongoClient = MongoClient(mongoHost, mongoPort)

  override def todoCollection = mongoClient(mongoDBname)("todo_item")
  
}
