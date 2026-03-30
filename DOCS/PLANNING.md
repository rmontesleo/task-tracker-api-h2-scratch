# Planning

## Project Context
This project is the foundational delivery baseline of the portfolio. It uses a simple Task CRUD API to practice backend structure, containerization, infrastructure provisioning, and cloud deployment. The main purpose is to create a reusable starting point for future projects, not to build a complex business domain.

## Audience
- Developers
- Interviewers
- Collaborators
- Me in the future


## Objective
Build a Spring Boot Task CRUD API that can run locally, in Docker, and on a Linode VM, with a basic Kubernetes deployment path, basic CI automation, and Terraform-managed infrastructure.

## Success Statement



## Scope

### In Scope
- SpringBoot Task CRUD API
- OpenAPI/Swagger
- H2 Database
- DTO, service, repository, mapper, exception handling
- Unit Testing
- Dockerfile and docker-compose
- GitHub Actions for a CI/CD pipeline
- Terraform for basic infrastructure
- VM Deployment on Linode
- Domain name pointing to deploy API
- Basic Kubernetes deployment path
- README and MIT Licence files


### Out of Scope
- Authentication/Authorization
- User management
- Frontend
- Production-grade persistent datase like MySQL or PostgreSQL
- Distributed traicing
- Messages Queues
- Microservices
- Advance Security Hardening
- Performance Testing
- Monitoring and Observability stack
- Advance Kubernetes capabilities
- Multicloud deployment
- Full automatic CD to all targets



### Selected Stack
- **Programming Language**: Java 25 
- **Framework**: SpringBoot 4
- **Database**:H2 Database
- **Containers**: Docker, docker-compose
- **Cloud**: Akamai Linode
- **Kubernetes**: Minikube (Local development), LKS (basic path)
- **Infrastructure as Code** :Terraform
- **Documentation**: Markdown, README
- **Licence**: MIT

## Expected Functionality
- Run the jar on localhost to use the API
- Run the docker image on local host to use the API
- Run the K8s deployment on localhost using Minikube
- Run the docker image on a Akamai Linode (VIrtual Machine)
- Run the on API on LKS (Linode Kubernetes Service)

## Acceptance Criteria
- API
    - Use layers for the application Controllers, Services, Entities, DTO, Repositories and Configuration
    - Use Controller to handle the request, response, exceptions.  The input, ouput data is sent to Services.
    - Use the proper HTTP response codes for GET, POST, PUT and DELETE operations. Code details on Appendix Table 1 Controller Response Codes.
    - Use Services between Controllers and Repositories, to handle business logic, use mappers to tranform objetcs.
    - Use Mappers to change betwewn DTO and Entities
    - Use Repositories to communicate with the Database
    - Include unit testing for controllers, services and repositories
- Containers
    - Create a Docker file with  images for each stage. Consider a proper image to use SDK and other with JRE 
    - Define base image, compile, testing, production
    - Create a docker compose file to run the container as a service in localhost
    - The docker compose must contain variables to use string interpolation to change by end values.
- Virtual Machine
    - Create a Linode (Virtual Machine) in Akamai to run the container with the docker compose.
    - Setup a domain for the VM to consume the API with hostname instead IP.
    - Setup SSL
    - Setup the VM to use Key instead password to connecte to it. Setup firewall
    - Configure the VM to consume the service by port 80 instead of the 8080.    
- Kubernetes
    - Create the manifest files to define the deployment, scaleset, mappings, secretes and services 
    - One manifest version contains all componentes in 1 file, other version one component per file.
    - Define the version to run on Minikube and test in localhost
    - Define the versonn to run on LKS Linode Kubernetes Service
    - Setup a domain for the Kubernetes cluster to consume the service by hostname instead IP.
    - Setup SSL
- Infrastructure as Code
    - Use terraform to create the require infrastructure for VM and K8s on Akamai.
    - Use variables to change region and values for vm and the k8s cluster.
- CI/CD
    - Define a CI/CD pipeline with GitHub Actions
    - The CI must contain phases
        - Compile
        - Build Image
        - Run Unit Testing 
        - Scan the docker image with Docker Scout
        - Upload the 
    - The CD must contain the following phases
        - Deploy the new image on the VM. Restarting the compose.
        - Deploy the new image on the K8s cluster.
- README.md
    - The file must contain objective
    - Instructions to run the project on localhost, to run the CI/CD, create infrastrcuture and deploy application.
- LICENSE   
    - The license used in the project is MIT

## Definition of Done
The project constist of an MVP and four extensions, the done definition 

### Done Summary
This project is done when the Task CRUD API works locally, in Docker, on a Linode VM, and through a basic Kubernetes deployment path; CI builds and tests the project successfully; Terraform provisions the required base infrastructure; the API is reachable through a domain name; and the README explains how to build, run, deploy, and destroy the environment. All other improvements are deferred to later projects or extensions.

1. The API supports create, read all, read by id, update and delete operations.
2. API endpoints return documented HTTP Codes
3. Swagger/OpenAPI documentation is accessible
4. The application runs locally with SpringBoot
5. The application runs through Docker and docker-compose
6. Unit Test runs locally and in CI
7. A Docker Image is publish on Docker Hub
8. README explain local run, container run, test execution and deployment steps
9. The repository includes MIT Licence
10. A release tag such as v1.0.0 is created
11. Any future improvement are moved to backlog, not added to this version.

---


## Appendix

### Table 1: Response Codes

| Controller | Method Name | Input Type | Output Type | HTTP Code | Description |
|---|---|---|---|---|---|
| TaskController | createTask | TaskDTO | TaskDTO | 201 | Create a new task and return the created resource |
| TaskController | getAllTasks | - | List<TaskDTO> | 200 | Retrieve all tasks from the system |
| TaskController | getTaskById | Long | TaskDTO | 200 | Retrieve a specific task by its identifier |
| TaskController | updateTask | Long, TaskDTO | TaskDTO | 200 | Update an existing task with new information |
| TaskController | deleteTask | Long | - | 204 | Remove a task from the system |


### Exaple of PayLoad


### Glosary