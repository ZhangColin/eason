FROM registry.cn-hangzhou.aliyuncs.com/micro-java/openjdk:8-jre-alpine

ADD target/*.jar app.jar

EXPOSE 8761

ENTRYPOINT ["java", "-jar", "/app.jar"]
