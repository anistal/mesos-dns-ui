package com.anistal.mesosdns.services

import com.anistal.mesosdns.constants.AppConstants
import spray.routing.HttpService

trait StaticService extends HttpService with AppConstants {

  val staticRoutes =
    pathPrefix("css") {
      getFromResourceDirectory("web/css")
    } ~
      pathPrefix("js") {
        getFromResourceDirectory("web/js")
      } ~
      pathPrefix("templates") {
        getFromResourceDirectory("web/templates")
      } ~
      pathPrefix("partials") {
        getFromResourceDirectory("web/partials")
      } ~
      pathSingleSlash {
        getFromResource("web/index.html")
      }
}