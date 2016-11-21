package com.anistal.mesosdns.runners

import akka.actor.Props
import akka.io.IO
import akka.pattern.ask
import com.anistal.mesosdns.actors.RouteActor
import com.anistal.mesosdns.constants.AppConstants
import com.anistal.mesosdns.helpers.Logging

import spray.can.Http

object MesosDNSRunner extends App with AppConstants with Logging {

  import com.anistal.mesosdns.implicits.ApplicationContext._

  val host = Option(config.getString("mesosdns.host")).getOrElse(ConstantDefaultHost)
  val port = Option(config.getInt("mesosdns.port")).getOrElse(ConstantDefaultPort)

  log.info(s"Starting server in $host:$port")

  val routeActor = system.actorOf(Props(new RouteActor), "spray-routes")
  IO(Http) ? Http.Bind(routeActor, interface = host, port = port)
}
