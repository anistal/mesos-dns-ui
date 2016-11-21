package com.anistal.mesosdns.actors

import akka.actor.{Actor, ActorRefFactory}
import com.anistal.mesosdns.services.{APIService, StaticService}
import com.typesafe.config.Config
import spray.routing.HttpService

class RouteActor(implicit config:Config)
  extends Actor with HttpService {

  val staticService = new StaticService {
    override implicit def actorRefFactory: ActorRefFactory = context
  }

  val apiService = new APIService {
    override implicit def actorRefFactory: ActorRefFactory = context
  }

  override def actorRefFactory = context

  def receive = runRoute(apiService.sessionRoutes ~ staticService.staticRoutes)
}
