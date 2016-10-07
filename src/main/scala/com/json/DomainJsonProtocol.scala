package com.json

import com.domain.{TempResp, ApiResponse, Todo}
import spray.json._

import scala.reflect.ClassTag

object DomainJsonProtocol extends DefaultJsonProtocol {

  implicit val TodoJsonFormat = jsonFormat4(Todo)

  //TODO remove when done
  implicit val TempRespJsonFormat = jsonFormat1(TempResp)

  implicit def ApiResponseJsonFormat[T: JsonFormat : ClassTag] = new RootJsonFormat[ApiResponse[T]] {
    override def read(json: JsValue): ApiResponse[T] = {
      ApiResponse(
        status = fromField[String](json,"status"),
        results = fromField[Option[List[T]]](json,"result"),
        errors = fromField[Option[String]](json,"errors")
      )
    }

    override def write(obj: ApiResponse[T]): JsValue = {
      JsObject(
        "status" -> JsString(obj.status),
        "errors" -> JsString(obj.errors.getOrElse("")),
        "result" -> obj.results.toJson
      )
    }
  }

}