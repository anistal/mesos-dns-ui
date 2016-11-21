package com.anistal.mesosdns.services

import com.anistal.mesosdns.constants.AppConstants
import com.anistal.mesosdns.helpers.{HttpHelper, Logging}
import com.anistal.mesosdns.models._
import org.json4s.native.Serialization._
import spray.routing.HttpService

trait APIService extends HttpService with AppConstants with HttpHelper with Logging {

  import com.anistal.mesosdns.implicits.ApplicationContext._

  val sessionRoutes =
    path(ConstantStatusEndpoint) {
      get {
        val result = statusMesosDNS(config.getString(ConstantMesosDNSEndpoint))
        val mesosDNS = read[MesosDNS](result)

        val nodesAndEdges = for {
          framework <- mesosDNS.frameworks
          task <- framework.tasks
        } yield {
          val nodes = List(
            Node(task.id, task.name, ConstantMediumSize, ConstantColorNode, ConstantMediumNodeShape, true))
          val nodesFromRecords = task.records.map(x => {
            Node(
              s"${x.host}-${x.name}", s"${x.host}", ConstantSmallSize, ConstantColorNode, ConstantSmallNodeShape, true)
          })
          val edgesFromRecords = task.records.map(x => Edge(task.id, s"${x.host}-${x.name}"))
          (nodes ++ nodesFromRecords, edgesFromRecords)
        }

        val nodesAndEdgesFramework = for {
          framework <- mesosDNS.frameworks
        } yield {
          val node = List(
            Node(framework.name, framework.name, ConstantBigSize, ConstantColorNode, ConstantBigNodeShape, true))
          val edges = framework.tasks.map(x => Edge(framework.name, x.id))
          (node, edges)
        }

        val nodes = (nodesAndEdges ++ nodesAndEdgesFramework).flatMap(a => a._1)
        val edges = (nodesAndEdges ++ nodesAndEdgesFramework).flatMap(a => a._2)

        complete(Graph(nodes, edges))
      }
    }
}
