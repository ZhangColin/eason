FROM registry.cn-hangzhou.aliyuncs.com/micro-java/openjdk:8-jre-alpine

MAINTAINER colin zhang_colin@163.com

ENV TZ="Asia/Shanghai" JVM_PARAMS=" " SPRING_PARAMS=" "

ADD target/*.jar app.jar

EXPOSE 9001

#ENTRYPOINT ["java", "-jar", "/app.jar"]
CMD java $JVM_PARAMS -Djava.security.egd=file:/dev/./urandom -jar /server.jar $SPRING_PARAMS

