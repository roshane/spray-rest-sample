package com.domain

import org.bson.types.ObjectId
import salat.annotations.raw.Key

/**
 * Created by roshane on 9/29/16.
 */

case class Todo(@Key("_id") id: String = new ObjectId().toString,
                label: String,
                description: String,
                completed: Boolean)

case class ApiResponse[+R](status: String,
                           results: Option[List[R]],
                           errors: Option[String]) {
  def getResult: List[R] = results.getOrElse(List.empty[R])
}

//TODO remove when done
case class TempResp(success: Boolean)