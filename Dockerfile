FROM amazoncorretto:11-alpine-jdk
MAINTAINER GabyDs
COPY target/GabyDs-0.0.1-SNAPSHOT.jar gabyds-app.jar
ENTRYPOINT ["java","-jar","/gabyds-app.jar"]