package com.service

import com.domain.{ApiResponse, Todo}

/**
 * Created by roshane on 9/29/16.
 */
trait TodoService {

  def findAll: ApiResponse[Todo]

  def findOne(id: String): ApiResponse[Option[Todo]]

  def markCompleted(id: String): ApiResponse[Option[Todo]]

  def delete(id: String): ApiResponse[Boolean]

  def deleteAll: ApiResponse[Boolean]

  def save(todo: Todo): ApiResponse[Todo]

  def findAllCompleted: ApiResponse[Todo]

  def findAllPending: ApiResponse[Todo]
}
