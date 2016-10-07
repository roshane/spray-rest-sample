package com.service.impl

import com.domain.{StatusCodes, ApiResponse, Todo}
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

  override def findAll: ApiResponse[Todo] = {
    val result = todoRepository.findAll
      .map(grater[Todo].asObject(_))
    ApiResponse(StatusCodes.success, Some(result), None)
  }

  override def deleteAll: ApiResponse[Boolean] = {
    todoRepository.deleteAll
    ApiResponse(StatusCodes.success, None, None)
  }

  override def markCompleted(id: String): ApiResponse[Option[Todo]] = {
    val result = todoRepository.markCompleted(id)
      .map(grater[Todo].asObject(_))
    ApiResponse(StatusCodes.success, Some(List(result)), None)
  }

  override def findOne(id: String): ApiResponse[Option[Todo]] = {
    val result = todoRepository.findOne(id)
      .map(grater[Todo].asObject(_))
    ApiResponse(StatusCodes.success, Some(List(result)), None)
  }

  override def delete(id: String): ApiResponse[Boolean] = {
    todoRepository.delete(id)
    ApiResponse(StatusCodes.success, None, None)
  }

  override def save(todo: Todo): ApiResponse[Todo] = {
    val count = todoRepository.save(todo)
    ApiResponse(if (count == 0) StatusCodes.failed else StatusCodes.success, None, None)
  }

  override def findAllCompleted: ApiResponse[Todo] = {
    val result = todoRepository.findAllCompleted
      .map(grater[Todo].asObject(_))
    ApiResponse(StatusCodes.success, Some(result), None)
  }

  override def findAllPending: ApiResponse[Todo] = {
    val result = todoRepository.findAllPending
      .map(grater[Todo].asObject(_))
    ApiResponse(StatusCodes.success, Some(result), None)
  }
}
