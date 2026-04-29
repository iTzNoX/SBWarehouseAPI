FROM eclipse-temurin:17-jdk

VOLUME /tmp

COPY target/warehouse-api.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]