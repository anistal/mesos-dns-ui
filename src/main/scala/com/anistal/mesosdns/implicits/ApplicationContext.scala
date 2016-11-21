package com.anistal.mesosdns.implicits

import akka.actor.ActorSystem
import akka.util.Timeout
import com.anistal.mesosdns.runners.MesosDNSRunner._
import com.typesafe.config.{Config, ConfigFactory}
import org.json4s.{DefaultFormats, Formats}
import spray.httpx.Json4sSupport

import scala.concurrent.duration._

object ApplicationContext extends Json4sSupport {

  implicit lazy val executionContext = scala.concurrent.ExecutionContext.Implicits.global
  implicit lazy val config: Config = ConfigFactory.load
  implicit lazy val system: ActorSystem  = ActorSystem(ConstantAkkaName, config)
  implicit lazy val timeout = Timeout(5.seconds)

  implicit val json4sFormats: Formats =  DefaultFormats

}
