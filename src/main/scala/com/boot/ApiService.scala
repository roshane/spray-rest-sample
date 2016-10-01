package com.boot

import akka.actor.Actor
import com.conf.ApiServiceModule
import com.domain.Todo
import com.escalatesoft.subcut.inject.Injectable
import com.service.TodoService
import spray.routing._
import spray.http._
import MediaTypes._

// we don't implement our route structure directly in the service actor because
// we want to be able to test it independently, without having to spin up an actor
class ApiServiceActor extends Actor with ApiService {

  // the HttpService trait defines only one abstract member, which
  // connects the services environment to the enclosing actor or test
  def actorRefFactory = context

  // this actor only runs our route, but you could add
  // other things here, like request stream processing
  // or timeout handling
  def receive = runRoute(appRoute)
}


// this trait defines our service behavior independently from the service actor
trait ApiService extends HttpService with Injectable {

  val bindingModule = ApiServiceModule

  val todoService = inject[TodoService]

  import com.json.DomainJsonProtocol._
  import spray.httpx.SprayJsonSupport._

  val appRoute =
    pathPrefix("api") {

      get {
        respondWithMediaType(`application/json`) {
          path("version") {
            complete {
              "ApiService V0.1"
            }
          } ~
            path("todo" / "findOne" / Segment) {
              (a) => complete {
                todoService.findOne(a)
              }
            } ~
            path("todo" / "findAll") {
              complete {
                todoService.findAll
              }
            }
        }
      }
    }
}