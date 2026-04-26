# Docker


## Docker Image

For the Project was selected a Docker image based on eclipse-temurin and alpine linux

### Downloading the docker images
```bash
# JDK for development
docker pull eclipse-temurin:25-jdk-alpine-3.22

# JRE for run application
docker pull eclipse-temurin:25-jre-alpine-3.22


# Recomendations to run docker scout for jre
docker scout quickview eclipse-temurin:25-jre-alpine-3.22

# And jdk
 docker scout quickview eclipse-temurin:25-jdk-alpine-3.22
```

## Building docker image
```bash
# build from project root
docker build -t task-tracker-api-h2:local .

# verify
docker images

# Run with local profile
docker run --rm  -d -p 8080:8080 \
-e SPRING_PROFILES_ACTIVE=local \
--name local-app \
task-tracker-api-h2:local

# Run with test profile
docker run --rm -d -p 8085:8080 \
-e SPRING_PROFILES_ACTIVE=test \
--name test-app \
task-tracker-api-h2:local

# Run with prod profile
docker run --rm -d -p 9090:8080 \
-e SPRING_PROFILES_ACTIVE=prod \
-e DB_URL=jdbc:h2:mem:productiondb \
-e DB_USERNAME=dbuser \
-e DB_PASSWORD=secret \
-e DB_DRIVER=org.h2.Driver \
--name prod-app \
task-tracker-api-h2:local

# Verify the containrs are running
curl http://localhost:8080/actuator/health

```

## Docker Compose file
```bash
#  Start for local profile
docker compose --env-file .env.local up --build -d

# Start for test profile
docker compose --env-file .env.test up --build -d

# Start for prod profile
docker compose --env-file .env.prod up --build -d

# end the compose
docker compose down



# upload container image to docker hub
version=<DEFINE_A_VERSION_FOR_THIS_IMAGE>
echo $version

#docker push

```