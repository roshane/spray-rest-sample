package com.boot

import com.domain.Todo
import org.specs2.mutable.Specification
import spray.testkit.Specs2RouteTest
import spray.http._

class MyServiceSpec extends Specification with Specs2RouteTest with ApiService {
  def actorRefFactory = system

  import spray.httpx.SprayJsonSupport._
  import com.json.DomainJsonProtocol._

  "ApiService" should {

    "return api-version for GET request to (/api/version)" in {
      Get("/api/version") ~> appRoute ~> check {
        contentType must_== ContentTypes.`application/json`
        responseAs[String] contains "ApiService V0.1"
      }
    }

    "return Todo    for GET request to (/api/todo/findOne)" in {
      Get("/api/todo/findOne/57efa486a028e1b277281466") ~> appRoute ~> check {
        responseAs[Todo].completed mustEqual false
        contentType mustEqual ContentTypes.`application/json`
      }
    }

    "return List[Todo] for GET request to (/api/todo/findAll)" in {
      Get("/api/todo/findAll") ~> appRoute ~> check {
        responseAs[List[Todo]].size mustNotEqual 0
        contentType mustEqual ContentTypes.`application/json`
      }
    }

    //        "leave GET requests to other paths unhandled" in {
    //          Get("/kermit") ~> appRoute ~> check {
    //            handled must beFalse
    //          }
    //        }
    //
    //    "return a MethodNotAllowed error for PUT requests to the root path" in {
    //      Put() ~> sealRoute(appRoute) ~> check {
    //        status === MethodNotAllowed
    //        responseAs[String] === "HTTP method not allowed, supported methods: GET"
    //      }
    //    }
  }
}
