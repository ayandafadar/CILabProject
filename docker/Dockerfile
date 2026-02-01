FROM maven:3.9.6-eclipse-temurin-11

WORKDIR /workspace
COPY pom.xml .
COPY src ./src

CMD ["mvn", "-q", "test"]
