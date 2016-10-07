package com.repository

import com.domain.Todo
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

  def save(todo: Todo): Int

  def findAllCompleted: List[DBObject]

  def findAllPending: List[DBObject]

}
