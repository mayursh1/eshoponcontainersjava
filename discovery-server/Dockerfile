FROM gradle:7.3.3-jdk17-alpine AS build
RUN mkdir /home/gradle/src
COPY --chown=gradle:gradle . /home/gradle/src

# Build
WORKDIR /home/gradle/src
COPY ./build/libs/* /home/gradle/src/build/libs/
RUN gradle build --no-daemon



# Contanerize
FROM openjdk:17-alpine

RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/*.jar /app/
ENTRYPOINT ["java","-jar","/app/discoveryserver-0.0.1-SNAPSHOT.jar"]