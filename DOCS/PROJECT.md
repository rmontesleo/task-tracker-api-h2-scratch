# Project Planning

## MVP 

### EPIC 1: API
- [] Create Boiler plate with Spring Initializer
- [] Startup application
- [] Create Mock Controller
- [] Create Swagger to see the API methods
- [] Implement Task Controller
    - [] POST operation
    - [] GET all operation
    - [] GET by Id operation
    - [] UPDATE by id operation
    - [] DELETE operation
- [] Define DTO objects for Controller
- [] Define Script to H2 Database
- [] Define Entities for DataBase
- [] Define Task Mappers
- [] Implement Task Service
- [] Implement Task Repository
- [] Implement Logger
- [] Implement Unit Testing
    - [] Testing for Controllers
    - [] Testing for Services
    - [] Testing for Repositories 

### EPIC 2 : Build Docker Image
- [] Create Docker file
    - [] Select Java Images for development and production
    - [] Define stage for development
    - [] Define stage for testing
    - [] Define stage for Production (an slim one)
- [] Create Docker compose file
- [] Create Docker image
- [] Push image on Docker Hub

### EPIC 3: Deployment on Linode Virtual Machine
- [] Define the VM to use for deployment
- [] Create a VM using the portal, for testing pourposes.
- [] Deploy the docker image.
- [] Generate script required to stop docker service, update image and star the new image
- [] Generate the script to create the VM with the Linode API

### EPIC 4: Basic Terraform VM Infrastructure 

### EPIC 5: Basic CI/CD pipeline

---

## Extension A: Basic Kubernetes 
- [] Create minikube local cluster 
- [] Define k8s elements
    - [] Deployment
    - [] Service
    - [] Mappings
    - [] Secrets
- [] Test Deployment
- [] Define Manifest for Minikube
- [] Create Linode Cluster
- [] Define Manifest for Linode

## Extension B: LKS Deployment


### Extension C: Implement IaC with Terraform
- [] Create terraform files for VM 
- [] Create terraform files for K8s Cluster 
- [] Define domain for application
- [] Setup the domain for the linode VM
- [] Setup teh domain for the K8s Cluster

### Extension D: Implement CI/CD (Part 1)
- [] Define de Pipeline
- [] Implement CI
    - [] Compile
    - [] Test
    - [] Build
    - [] Scan Image with Docker scout
    - [] Upload Docker Hub
- [] Implement CD
    - [] Deploy on VM
    - [] Deploy on K8s Cluster

### Extension E: TLS/SSL

