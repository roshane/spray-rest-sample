package com.repository

import com.domain.Todo

/**
 * Created by roshane on 9/29/16.
 */
trait TodoRepository {

  def findAll: List[Todo]

  def findOne(id: String): Option[Todo]

  def markCompleted(id: String): Option[Todo]

  def delete(id: String): Unit

  def deleteAll: Unit

}
