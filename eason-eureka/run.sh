#!/usr/bin/env bash
mvn clean package -Dmaven.test.skip=true

nohup java -jar target/eason-eureka-1.0-SNAPSHOT.jar >> /dev/null 2>&1 &
