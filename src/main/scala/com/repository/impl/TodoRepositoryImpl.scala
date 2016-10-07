package com.repository.impl

import com.db.Db
import com.domain.Todo
import com.escalatesoft.subcut.inject.{BindingModule, Injectable}
import com.mongodb.DBObject
import com.mongodb.casbah.commons.MongoDBObject
import com.repository.TodoRepository
import org.bson.types.ObjectId

/**
 * Created by roshane on 9/29/16.
 */
class TodoRepositoryImpl(implicit val bindingModule: BindingModule) extends TodoRepository
with Injectable {

  private val db = inject[Db]

  override def findAll: List[DBObject] = {
    db.todoCollection.find().toList
  }

  override def deleteAll: Unit = {
    db.todoCollection.remove(MongoDBObject())
  }

  override def markCompleted(id: String): Option[DBObject] = {
    db.todoCollection.findAndModify(
      MongoDBObject("_id" -> new ObjectId(id)),
      MongoDBObject("$set" -> MongoDBObject("completed" -> true)))
  }

  override def findOne(id: String) = {
    db.todoCollection.findOneByID(new ObjectId(id))
  }

  override def delete(id: String) {
    db.todoCollection.remove(MongoDBObject("_id" -> new ObjectId(id)))
  }

  override def save(todo: Todo): Int = {
    val result = db.todoCollection.insert(MongoDBObject(
      "_id" -> todo.id,
      "label" -> todo.label,
      "description" -> todo.description,
      "completed" -> false
    ))
    result.getN
  }

  override def findAllCompleted: List[DBObject] = {
    db.todoCollection.find(MongoDBObject("completed" -> true)).toList
  }

  override def findAllPending: List[DBObject] = {
    db.todoCollection.find(MongoDBObject("completed" -> false)).toList
  }
}
