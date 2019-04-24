FROM maven:3.5.3-jdk-8 AS build
WORKDIR /build
ADD ./ /build
RUN mvn clean install package

FROM openjdk:8-jdk-alpine
WORKDIR /api
COPY --from=build /build/target/tree-1.0.0.jar /api/tree-1.0.0.jar 
CMD [ "java", "-jar", "-Dspring.profiles.active=prod", "tree-1.0.0.jar" ]