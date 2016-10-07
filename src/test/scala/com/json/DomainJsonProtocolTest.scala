package com.json

import com.domain.{Todo, ApiResponse, TempResp}
import org.specs2.mutable.Specification

/**
 * Created by roshane on 10/6/16.
 */
class DomainJsonProtocolTest extends Specification {

  import spray.json._
  import DomainJsonProtocol._

  "DomainJsonProtocol" should {

    "DeSerialize Todo" in {

      val source =
        """{
            "id": "57f65e5a1b681482dfd226d2",
            "label": "label",
            "description": "todo description",
            "completed": false
          }"""

      val jsValue = source.parseJson
      jsValue.convertTo[Todo].isInstanceOf[Todo] mustEqual true
    }

    "Serialize Todo to json" in {

      val source = Todo(label = "label", description = "todo description", completed = false)
      val jsValue = source.toJson
      println(jsValue.prettyPrint)
      true
    }

    "Serialize ApiResponse to json" in {

      val source = ApiResponse("Success",
        Some(List(Todo(label = "1", description = "some description", completed = false))),
        errors = None)
      val jsValue = source.toJson
      println(jsValue.prettyPrint)
      true
    }

    "DeSerialize ApiResponse" in {

      val source =
        """{
                     "status": "Success",
                     "errors": "",
                     "result": [{
                       "id": "57f663cb1b687cb0aba97f46",
                       "label": "1",
                       "description": "some description",
                       "completed": false
                     }, {
                       "id": "57f663cb1b687cb0aba97f46",
                       "label": "2",
                       "description": "some description",
                       "completed": false
                     }, {
                       "id": "57f663cb1b687cb0aba97f46",
                       "label": "3",
                       "description": "some description",
                       "completed": false
                     }, {
                       "id": "57f663cb1b687cb0aba97f46",
                       "label": "4",
                       "description": "some description",
                       "completed": false
                     }]
                   }"""

      val jsValue = source.parseJson
      jsValue.convertTo[ApiResponse[Todo]].getResult.size mustNotEqual 0

    }
  }
}
