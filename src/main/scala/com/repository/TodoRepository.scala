package com.repository

import com.mongodb.DBObject

/**
 * Created by roshane on 9/29/16.
 */
trait TodoRepository {

  def findAll: List[DBObject]

  def findOne(id: String): Option[DBObject]

  def markCompleted(id: String): Option[DBObject]

  def delete(id: String): Unit

  def deleteAll: Unit

}
