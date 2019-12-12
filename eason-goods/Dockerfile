FROM registry.cn-hangzhou.aliyuncs.com/micro-java/openjdk:8-jre-alpine

MAINTAINER colin zhang_colin@163.com

ADD target/*.jar app.jar

EXPOSE 9002

ENTRYPOINT ["java", "-jar", "/app.jar"]
