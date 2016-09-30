package com.json

import com.domain.Todo
import spray.json._

object DomainJsonProtocol extends DefaultJsonProtocol {

  implicit val TodoJsonFormat = jsonFormat3(Todo)

}