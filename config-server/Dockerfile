FROM gradle:7.3.3-jdk17-alpine AS build
RUN mkdir /home/gradle/src
COPY --chown=gradle:gradle . /home/gradle/src

# Build
WORKDIR /home/gradle/src
COPY . .
RUN gradle build --no-daemon



# Contanerize
FROM openjdk:17-alpine
RUN apk add --update curl && \
  rm -rf /var/cache/apk/*
RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/*.jar /app/

ENTRYPOINT ["java","-jar","/app/configserver-0.0.1-SNAPSHOT.jar"]