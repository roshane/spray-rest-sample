package com.boot

import akka.actor.Actor
import com.conf.ApiServiceModule
import com.domain.{TempResp, ApiResponse, Todo}
import com.escalatesoft.subcut.inject.Injectable
import com.service.TodoService
import spray.routing._
import spray.routing.directives._
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
              ("version-1.0")
            }
          } ~
            path("todo" / "findOne" / Segment) {
              (id) => complete {
                todoService.findOne(id)
              }
            } ~
            path("todo" / "findAll") {
              complete {
                todoService.findAll
              }
            }~
            path("todo" / "findAll" / "completed"){
              complete{
                todoService.findAllCompleted
              }
            }~
            path("todo" / "findAll" / "pending"){
              complete{
                todoService.findAllPending
              }
            }
        }
      } ~
        put {
          respondWithMediaType(`application/json`) {
            path("todo" / "completed" / Segment) {
              (id) => complete {
                todoService.markCompleted(id)
              }
            }
          }
        } ~
        delete {
          respondWithMediaType(`application/json`) {
            path("todo" / "delete" / Segment) {
              (id) => {
                complete {
                  todoService.delete(id)
                  TempResp(true)
                }
              }
            } ~
              path("todo" / "deleteAll") {
                complete {
                  todoService.deleteAll
                  TempResp(true)
                }
              }
          }
        } //~
//        post {
//          respondWithMediaType(`application/json`) {
//            path("todo" / "add") {
//              entity(as[Todo]){
//                todo=>{
//                  complete{
//                    todoService.save(todo)
//                  }
//                }
//              }
//            }
//          }
//        }
    }
}