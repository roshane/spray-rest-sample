package com.repository.impl

import com.domain.Todo
import com.repository.TodoRepository

/**
 * Created by roshane on 9/29/16.
 */
class TodoRepositoryImpl extends TodoRepository {

  override def findAll: List[Todo] = {
    val list = List(
      Todo("1", "completed todo item", true),
      Todo("2", "completed todo item", true),
      Todo("3", "completed todo item", true),
      Todo("4", "completed todo item", true),
      Todo("5", "completed todo item", true),
      Todo("6", "completed todo item", true)
    )
    println("returning all todos", list)
    list
  }

  override def deleteAll: Unit = {
    println("deleting all todos")
  }

  override def markCompleted(id: String): Option[Todo] = {
    val todo = Todo("completed", "completed todo item", true)
    println("returning value " + todo)
    Option(todo)
  }

  override def findOne(id: String) = {
    val todo = Todo("some todo", "some description", false)
    println("returning value " + todo)
    Option(todo)
  }

  override def delete(id: String) {
    print("deleted all data")
  }
}
