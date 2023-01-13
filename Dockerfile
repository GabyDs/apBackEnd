FROM amazoncorretto:11-alpine-jdk  // imagen de java de la cual se parte
MAINTAINER GabyDs  // dueño de la imagen
COPY target/GabyDs-0.0.1-SNAPSHOT gabyds-app.jar  // va a copiar el empaquetado del proyecto y lo sube a github
ENTRYPOINT ["java","-jar","/gabyds-app.jar"]  // primera instruccion a ejecutar