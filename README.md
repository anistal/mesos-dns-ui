# Description
Mesos DNS UI is a small application that makes requests to master.mesos:8123/v1/enumerate and paint the result in a graph with all dns entries.
It could be useful to take a quick look of which dns entries and ports are availabe in the cluster

# Compile and run
To generate a fat jar: sbt clean assembly
To run the project: java -jar ~/mesos-dns-ui/target/scala-2.11/mesos-dns-ui-assembly-0.1.jar

# Screenshot
![alt text](https://github.com/anistal/mesos-dns-ui/blob/master/screenshot.png "Screenshot")

