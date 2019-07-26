FROM openjdk:8-jre-slim

ARG APP_VERSION=0.1.0-SNAPSHOT

WORKDIR /opt/contacts-app

COPY target/contacts-app-$APP_VERSION.jar /opt/contacts-app/contacts-app.jar
COPY config.yaml /opt/contacts-app/config.yaml

ENTRYPOINT ["java", "-jar", "contacts-app.jar"]

# Parameters set as Default
CMD ["server", "config.yaml"]