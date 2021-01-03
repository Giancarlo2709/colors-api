FROM adoptopenjdk/openjdk11:alpine-jre

ARG JAR_FILE=target/colors-api-0.0.1-SNAPSHOT.jar

WORKDIR /opt/app

# cp target/colors-api-0.0.1-SNAPSHOT.jar /opt/app/app.jar
COPY ${JAR_FILE} app.jar

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]