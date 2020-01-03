FROM openjdk:11.0.5
VOLUME /tmp
COPY target/inz-1.0-SNAPSHOT-spring-boot.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","app.jar"]