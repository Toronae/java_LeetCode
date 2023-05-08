Oracle.ManagedDataAccess.Core NuGet Package 3.21.1 README
=========================================================
Release Notes: Oracle Data Provider for .NET Core

February 2021

This provider supports .NET Core 3.1 and .NET 5.

New Features
============
1) Native JSON Data Type
ODP.NET supports the native JavaScript Object Notation (JSON) data type in 
Oracle Database. The new JSON data type is optimized for query and DML 
processing, yielding database performance improvements processing JSON.
When using a .NET string or OracleString, JSON data can be bound as a parameter 
using the OracleDbType.Json enumeration value.

2) Sharding
ODP.NET Core now support sharding. Oracle Sharding provides the ability to 
horizontally partition the data across multiple independent Oracle databases 
(shards). Based on a key specified in the connect string, ODP.NET can route 
the database requests to a particular shard.
Oracle Sharding is a shared-nothing architecture that allows near-linear 
scaling of the database across low-cost commodity database servers located in 
one or more local or global data centers. Other key benefits include global 
data distribution (store particular data close to consumers) and fault 
containment (failure of one shard does not affect the availability of other 
shards). Global Data Services manages the location of data among the shards 
and allows ODP.NET client requests to be routed to the appropriate shard in 
this distributed database system.
In addition to the same sharding functionality that unmanaged ODP.NET 
supports, ODP.NET Core also supports pausing connection requests 
during chunk migrations. Users will not experience a timeout without giving 
the chunk sufficient time to migrate across shards.

3) Client Initiated Continuous Query Notification
Client Initiated Continuous Query Notification (CICQN) is similar to the 
traditional Continuous Query Notification (CQN) feature available in ODP.NET. 
In CQN, applications receive client-side notifications when server side change 
occurs that would affect the client’s query result set, the underlying schema 
objects, or the database state. This notification is out of process, occurring 
without an existing ODP.NET connection. 
CICQN uses in-process notifications. ODP.NET creates one separate connection 
per pool for receiving notifications. The database server uses this specific 
connection to send change notifications to ODP.NET. CICQN is useful when out of 
process communications is not available between client and database server, 
such as in cloud deployments.

4) New Administrative Privileges
ODP.NET Core now supports assignment of task-specific and least-privileged 
administrative privileges to enable database administrator duty separation. 
The newly added privileges include SYSBACKUP for backup and recovery, SYSDG 
for Oracle Data Guard, and SYSKM for encryption key management, and SYSRAC 
for Oracle Real Applications Clusters operations.

5) Debug Tracing Redaction
ODP.NET Core has introduced a new trace level, that can 
exclude SQL statements and network packet contents from being included in the 
trace file.

Bug Fixes since Oracle.ManagedDataAccess.Core NuGet Package 2.19.101
====================================================================
Bug 32370414 - SEMAPHOREFULLEXCEPTION ENCOUNTERED UNDER HEAVY LOAD
Bug 32185056 - ORA-01017 ENCOUNTERED WHEN PASSWORD HAS A TRAILING EQUAL SIGN

 Copyright (c) 2021, Oracle and/or its affiliates. 
