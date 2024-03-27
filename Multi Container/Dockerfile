FROM openjdk:22-jdk
LABEL authors="Nittan Kumar"

ENV SPRING_DATASOURCE_URL jdbc:mysql://docker-mysql:3306/dockerdemo  #Updated port
ENV SPRING_DATASOURCE_USERNAME root
ENV SPRING_DATASOURCE_PASSWORD nittan

ADD target/docker-studentApp.jar docker-studentApp.jar

ENTRYPOINT ["java", "-jar", "/docker-studentApp.jar"]



#FROM openjdk:22-jdk
#LABEL authors="Nittan Kumar"
##ENV PORT 8080
##EXPOSE 8080
#ADD target/docker-studentApp.jar docker-studentApp.jar
#
#ENTRYPOINT ["java", "-jar", "/docker-studentApp.jar"]