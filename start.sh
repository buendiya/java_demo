#!/usr/bin/env bash

#NAME
#       java - Java application launcher
#
#SYNOPSIS
#       java [ options ] class [ argument...  ]
#
#       java [ options ] -jar file.jar
#            [ argument...  ]

java -cp target/demo-1.0-SNAPSHOT.jar Main


# mainclass 在pom.xml 里配置
java -jar target/demo-1.0-SNAPSHOT-jar-with-dependencies.jar