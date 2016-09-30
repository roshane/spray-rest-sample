package com.service.impl

import com.domain.Todo
import com.escalatesoft.subcut.inject.{BindingModule, Injectable}
import com.repository.TodoRepository
import com.service.TodoService

/**
 * Created by roshane on 9/29/16.
 */
class TodoServiceImpl(implicit val bindingModule: BindingModule) extends TodoService with Injectable {

  private val todoRepository = inject[TodoRepository]

  override def findAll: List[Todo] = todoRepository.findAll

  override def deleteAll: Unit = todoRepository.deleteAll

  override def markCompleted(id: String): Option[Todo] = todoRepository.markCompleted(id)

  override def findOne(id: String): Option[Todo] = todoRepository.findOne(id)

  override def delete(id: String): Unit = todoRepository.delete(id)
}
