package com.anistal.mesosdns.models

case class Node(id: String, label: String, size: Int, color: String, shape: String, shadow: Boolean)
case class Graph(nodes: List[Node], edges: List[Edge])
case class Edge(from: String, to: String)
