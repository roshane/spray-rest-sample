package com.repository.impl

import com.conf.ApiServiceModule
import com.escalatesoft.subcut.inject.Injectable
import com.repository.TodoRepository
import org.specs2.mutable.Specification

/**
 * Created by roshane on 10/6/16.
 */
class TodoRepositoryTest extends Specification with Injectable {

  implicit val bindingModule = ApiServiceModule

  private val repository = inject[TodoRepository]

  "TodoRepository" should {

    "FindAll todo items" in {
      val result = repository.findAll
      println(result)
      result.size mustNotEqual 0
    }
  }

}
