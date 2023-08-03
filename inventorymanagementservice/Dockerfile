FROM khipu/openjdk17-alpine
RUN addgroup -S spring && adduser -S shamstabrez542 -G spring
USER shamstabrez542:spring
VOLUME /tmp
ARG JAR_FILE=target/inventorymanagementservice-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} /app/inventorymanagementservice.jar
EXPOSE 8082
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/inventorymanagementservice.jar"]