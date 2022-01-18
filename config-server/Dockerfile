FROM gradle:7.3.3-jdk17-alpine AS build
RUN mkdir /home/gradle/src
COPY --chown=gradle:gradle . /home/gradle/src
ARG discoveryhost
ARG discoveryport

# Build
WORKDIR /home/gradle/src
RUN echo discoveryhost=$discoveryhost >> gradle.properties
RUN echo discoveryport=$discoveryport >> gradle.properties
COPY . .
RUN gradle build --no-daemon



# Contanerize
FROM openjdk:17-alpine

RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/*.jar /app/
ENTRYPOINT ["java","-jar","/app/configserver-0.0.1-SNAPSHOT.jar"]