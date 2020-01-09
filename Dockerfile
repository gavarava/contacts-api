FROM openjdk:8-jre-alpine

WORKDIR /opt/contacts-app

RUN apk --no-cache add curl
RUN curl -o h2.jar https://repo1.maven.org/maven2/com/h2database/h2/1.4.199/h2-1.4.199.jar

COPY target/libs/app/contacts-app-*.jar contacts-app.jar
COPY src/main/resources/scripts/ scripts/
COPY src/main/resources/deploymentConfiguration.yaml config.yaml

RUN ./scripts/createDatabase.sh

# Start the H2 Database server and Application at the same time
ENTRYPOINT ["sh", "./scripts/runApplicationAndDatabase.sh"]