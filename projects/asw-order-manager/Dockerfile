FROM eclipse-temurin

ARG SERVICE_NAME

ADD $SERVICE_NAME/build/libs/$SERVICE_NAME.jar target.jar

EXPOSE 8080

ENTRYPOINT ["java", "-Xmx128m", "-Xms128m", "-jar", "target.jar"]