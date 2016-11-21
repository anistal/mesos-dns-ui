package com.anistal.mesosdns.implicits

import org.json4s.{DefaultFormats, Formats}
import spray.httpx.Json4sSupport

trait ApplicationSerializer extends Json4sSupport {

  implicit val json4sFormats: Formats =  DefaultFormats
}
