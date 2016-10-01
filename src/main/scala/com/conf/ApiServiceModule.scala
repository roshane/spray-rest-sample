package com.conf

import com.db.Db
import com.db.impl.DefaultDb
import com.escalatesoft.subcut.inject.NewBindingModule
import com.repository.TodoRepository
import com.repository.impl.TodoRepositoryImpl
import com.service.TodoService
import com.service.impl.TodoServiceImpl
import com.typesafe.config.{ConfigFactory, ConfigUtil}

/**
 * Created by roshane on 9/29/16.
 */
object ApiServiceModule extends NewBindingModule(implicit module => {
  import module._

  val applicationConfig = ConfigFactory.load("application").getConfig("app")

  bind[String] idBy "mongo.host" toSingle applicationConfig.getConfig("mongo").getString("host")
  bind[Int] idBy "mongo.port" toSingle applicationConfig.getConfig("mongo").getInt("port")
  bind[String] idBy "mongo.dbname" toSingle applicationConfig.getConfig("mongo").getString("dbname")

  bind[Db] toSingle new DefaultDb
  bind[TodoService] toSingle new TodoServiceImpl
  bind[TodoRepository] toSingle new TodoRepositoryImpl

})
