config kafka
(Format the Kafka Storage):

step :1 

C:\pbaithi\kafka>.\bin\windows\kafka-storage.bat random-uuid
2025-05-15T05:35:18.707550400Z main ERROR Reconfiguration failed: No configuration found for '266474c2' at 'null' in 'null'
70YhrhMtQk2jwVpRK12BMw

step 2:

C:\pbaithi\kafka>.\bin\windows\kafka-storage.bat format -t 4sAcUmVNTPmaCyKT_HdL7w -c .\config\server.properties  --standalone
2025-05-15T05:44:31.006342300Z main ERROR Reconfiguration failed: No configuration found for '266474c2' at 'null' in 'null'
Formatting dynamic metadata voter directory /tmp/kraft-combined-logs with metadata.version 4.0-IV3.
=====================================

Start Kafka in standalone mode (KRaft):

.\bin\windows\kafka-server-start.bat .\config\server.properties
=============================================


Create a Topic:

C:\pbaithi\kafka>.\bin\windows\kafka-topics.bat --create --topic test-topic --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1
2025-05-15T05:47:35.835993900Z main ERROR Reconfiguration failed: No configuration found for '266474c2' at 'null' in 'null'
Created topic test-topic.

Check the topic:

.\bin\windows\kafka-topics.bat --list --bootstrap-server localhost:9092
================================================================
Produce a Message:

.\bin\windows\kafka-console-producer.bat --topic test-topic --bootstrap-server localhost:9092
==============================================================================================

Consume the Message

.\bin\windows\kafka-console-consumer.bat --topic test-topic --from-beginning --bootstrap-server localhost:9092
.\bin\windows\kafka-console-consumer.bat --topic transactions --from-beginning --bootstrap-server localhost:9092

=============================================================================

