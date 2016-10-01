package com.service.impl

import com.domain.Todo
import com.escalatesoft.subcut.inject.{BindingModule, Injectable}
import com.repository.TodoRepository
import com.service.TodoService
import salat._
import salat.global._
import com.mongodb.casbah.Imports._

/**
 * Created by roshane on 9/29/16.
 */
class TodoServiceImpl(implicit val bindingModule: BindingModule) extends TodoService with Injectable {

  private val todoRepository = inject[TodoRepository]

  override def findAll: List[Todo] = {
    todoRepository.findAll
      .map(grater[Todo].asObject(_))
  }

  override def deleteAll: Unit = todoRepository.deleteAll

  override def markCompleted(id: String): Option[Todo] = {
    todoRepository.markCompleted(id)
      .map(grater[Todo].asObject(_))
  }

  override def findOne(id: String): Option[Todo] = {
    todoRepository.findOne(id)
      .map(grater[Todo].asObject(_))
  }

  override def delete(id: String): Unit = todoRepository.delete(id)
}
