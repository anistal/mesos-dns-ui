package com.anistal.mesosdns.helpers

import org.apache.http.HttpStatus
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.HttpClientBuilder
import org.apache.http.util.EntityUtils


trait HttpHelper {

  def statusMesosDNS(endpoint: String): String = {
    val client = HttpClientBuilder.create().build()
    val get = new HttpGet(endpoint)
    get.setHeader("Content-type", "application/json")
    val response = client.execute(get)

    if (response.getStatusLine.getStatusCode != HttpStatus.SC_OK)
      throw new IllegalStateException(s"Status code is not OK: ${response.getStatusLine.getStatusCode}")
    else {
      val entity = response.getEntity
      EntityUtils.toString(entity)
    }
  }
}
