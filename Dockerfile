# --- Stage 1: Build the application ---
FROM eclipse-temurin:25-jdk-alpine-3.22 AS builder
WORKDIR /app

# Copy build files frist to leverage Docker cache for dependencies
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN chmod +x mvnw

# Download dependencies first
RUN --mount=type=cache,target=/root/.m2,id=maven \
    ./mvnw dependency:go-offline -B

# Copy source code and build
COPY src ./src
RUN --mount=type=cache,target=/root/.m2,id=maven \
    ./mvnw -B clean package -DskipTests


# --- Stage 2: Runtime image ---
FROM eclipse-temurin:25-jre-alpine-3.22 AS runtime
WORKDIR /app

# Create a non-root user for security
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

# Copy the executable jar from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Optimize JVM for container environments
ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0"
ENV SPRING_PROFILES_ACTIVE=local

# Document the port
EXPOSE 8080

# TODO: the local profile is temporal while this part is improved
ENTRYPOINT [ "sh", "-c", "exec java $JAVA_OPTS -jar app.jar" ]