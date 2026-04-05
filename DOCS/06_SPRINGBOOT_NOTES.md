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