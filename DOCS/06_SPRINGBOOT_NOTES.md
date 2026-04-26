# SPRINGBOOT NOTES

## 1. Running springboot
```bash
# in root  using the Maven Wrapper
./mvnw spring-boot:run

# create jar and run it
JAR_NAME="CHANGE_IT_FOR_JAR_NAME"

./mvnw clean package
java -jar target/$JAR_NAME

```

## 2. Swagger Configuration
In first versions of SpringBoot SpringFox was used, now springdoc-openapi-starter-webmvc-ui check [Migrating from SpringFox](https://springdoc.org/migrating-from-springfox.html?utm_source=chatgpt.com) for more references

Verify the URL
```bash

# Open Swagger documentation
http://localhost:8080/swagger-ui/index.html

# Returns JSON
http://localhost:8080/v3/api-docs

```

## 3. Curl operations
TODO:  Add samples of curl operations

## 4. H2 Console

```bash
# Open H2 Console
http://localhost:8080/h2-console

# Verify the configuration in yaml file and configurations

# For dev, check this values in console
url: jdbc:h2:mem:taskdb
driver-class-name: org.h2.Driver
username: sa
password: ""

```

## 5. Profiles
```bash
# Maven wrapper with profile, local, test and prod
./mvnw spring-boot:run -Dspring-boot.run.profiles=local
./mvnw spring-boot:run -Dspring-boot.run.profiles=test
./mvnw spring-boot:run -Dspring-boot.run.profiles=prod

# Running with the jar file
# Note: Always verify the current name of your jar to set valo to the environment variable 
JAR_FILE=target/task-tracker-api-h2-scratch-0.0.1.jar

java -jar $JAR_FILE --spring.profiles.active=local
java -jar $JAR_FILE --spring.profiles.active=test
java -jar $JAR_FILE --spring.profiles.active=prod

# To run the prod profile require environment variables, we can define in this way

# Case 1, define the variable who the values will be replace
export SPRING_PROFILES_ACTIVE=prod
export DB_URL=jdbc:h2:mem:productiondb
export DB_USERNAME=dbuser
export DB_PASSWORD=secret
export DB_DRIVER=org.h2.Driver
export SERVER_PORT=9090
export ROOT_LOG_LEVEL=WARN
./mvnw spring-boot:run

# Case 2: using spring like style variable to set require values
export SPRING_PROFILES_ACTIVE=prod
export SPRING_DATASOURCE_URL=jdbc:h2:mem:productiondb2
export SPRING_DATASOURCE_USERNAME=superuser
export SPRING_DATASOURCE_PASSWORD=supesecret
export SPRING_DATASOURCE_DRIVER_CLASS_NAME=org.h2.Driver
export SERVER_PORT=7070
export SPRING_LOGGING_LEVEL_ROOT=WARN
./mvnw spring-boot:run


# Case 3: you can override some env variables
# Running with the jar file
# Note: Always verify the current name of your jar to set valo to the environment variable 
JAR_FILE=target/task-tracker-api-h2-scratch-0.0.1.jar

# Define your env variables are sett
export SPRING_PROFILES_ACTIVE=prod
export DB_URL=jdbc:h2:mem:productiondb
export DB_USERNAME=dbuser
export DB_PASSWORD=secret
export DB_DRIVER=org.h2.Driver
export SERVER_PORT=9090
export ROOT_LOG_LEVEL=WARN

# !IMPORTANT: When running the jar, verify you have the last version.  Check with
mvn clean package 

#or
./mvnw clean package

# Execute the jar, overriding the port and the logging level
java -jar $JAR_FILE \
--server.port=8585 \
--logging.level.com.demo.tasktracker=DEBUG

```

## 6. Testing

```bash
# Execute all test
./mvnw test

# Execute the test from class HttpRequestTest
./mvnw -Dtest=HttpRequestTest test
```

```bash
# to run all unit tests
./mvnw test

# full verification lifecycle
./mvnw verify

# Run one test class
./mvnw -Dtest=TaskServiceTest test

# Run one specific test method
./mvnw -Dtest=TaskServiceTest#getAllTasks_shouldReturnDtoList test

# Run with test profile
./mvnw test -Dspring.profiles.active=test

# Clean ant test
./mvnw clean test



```