package com.anistal.mesosdns.models

case class MesosDNS(frameworks: List[MesosFramework])
case class MesosFramework(name: String, tasks: List[MesosTask])
case class MesosTask(id: String, name: String, records: List[MesosRecord])
case class MesosRecord(name: String, host: String, rtype: String)