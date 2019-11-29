FROM hub.c.163.com/library/java:8-alpine

MAINTAINER colin zhang_colin@163.com

ADD target/*.jar app.jar

EXPOSE 8887

ENTRYPOINT ["java", "-jar", "/app.jar"]
