package com.boot

import com.domain.{ApiResponse, Todo}
import org.specs2.mutable.Specification
import spray.testkit.Specs2RouteTest
import spray.http._

class ApiServiceSpec extends Specification with Specs2RouteTest with ApiService {
  def actorRefFactory = system

  import spray.httpx.SprayJsonSupport._
  import com.json.DomainJsonProtocol._

  "ApiService" should {

    "return api-version for GET request to (/api/version)" in {
      Get("/api/version") ~> appRoute ~> check {
        contentType must_== ContentTypes.`application/json`
        responseAs[String] contains "version-1.0"
      }
    }

    "return Todo    for GET request to (/api/todo/findOne)" in {
      Get("/api/todo/findOne/57eff1b51e3996adc4fe25f2") ~> appRoute ~> check {
        responseAs[ApiResponse[Todo]].status mustEqual com.domain.StatusCodes.success
        contentType mustEqual ContentTypes.`application/json`
      }
    }

    "return List[Todo] for GET request to (/api/todo/findAll)" in {
      Get("/api/todo/findAll") ~> appRoute ~> check {
        val result=responseAs[ApiResponse[Todo]].results.getOrElse(List.empty)
        println("findAll result "+ result)
        result.size mustNotEqual 0
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
