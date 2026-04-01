# Project 1 Breakdown
Task CRUD API with Spring Boot, Docker, VM deployment on Linode, basic Terraform, basic CI, and domain.
Kubernetes, CD, TLS, and stronger infrastructure maturity are handled as extensions.

---

# MVP Breakdown

## EPIC 0: Planning and Repository Setup
- [ ] Create Git repository
- [ ] Define repository structure
  - [ ] `/src`
  - [ ] `/docs`
  - [ ] `/infra`
  - [ ] `/deploy`
  - [ ] `/k8s`
- [ ] Add initial `README.md`
- [ ] Add `LICENSE` with MIT
- [ ] Add `.gitignore`
- [ ] Add project planning document
- [ ] Define MVP scope and backlog section
- [ ] Define versioning convention for the project

## EPIC 1: API Baseline
- [ ] Create boilerplate with Spring Initializr
- [ ] Start application successfully
- [ ] Create health or mock controller for first verification
- [ ] Add OpenAPI / Swagger UI
- [ ] Define Task domain
  - [ ] Define `Task` entity
  - [ ] Define DTOs
  - [ ] Define mapper(s)
  - [ ] Define repository
  - [ ] Define service
  - [ ] Define controller
- [ ] Implement CRUD operations
  - [ ] POST `/tasks`
  - [ ] GET `/tasks`
  - [ ] GET `/tasks/{id}`
  - [ ] PUT `/tasks/{id}`
  - [ ] DELETE `/tasks/{id}`
- [ ] Define HTTP response codes
- [ ] Implement request validation
- [ ] Implement exception handling
  - [ ] Invalid input
  - [ ] Resource not found
  - [ ] Generic server error handling
- [ ] Add logging baseline


## EPIC 2: Local Persistence and Runtime
- [ ] Configure H2 database
- [ ] Define schema initialization approach
  - [ ] schema script or auto-generation
- [ ] Add sample seed data if useful
- [ ] Verify CRUD works locally with H2
- [ ] Externalize local configuration in `application.yml` / profiles

## EPIC 3: Testing Baseline
- [ ] Add test dependencies
- [ ] Implement unit tests for controller layer
- [ ] Implement unit tests for service layer
- [ ] Implement repository tests
- [ ] Verify core CRUD scenarios are covered
- [ ] Verify not-found scenario
- [ ] Verify validation scenario
- [ ] Ensure tests run locally

## EPIC 4: Containerization Baseline
- [ ] Create multi-stage Dockerfile
  - [ ] Builder stage
  - [ ] Runtime stage
- [ ] Select Java base image for build stage
- [ ] Select slim runtime image
- [ ] Build Docker image locally
- [ ] Run container locally
- [ ] Verify API works from container
- [ ] Create `docker-compose.yml`
- [ ] Run application with docker-compose
- [ ] Externalize environment variables where needed
- [ ] Push image to Docker Hub

## EPIC 5: Basic CI
- [ ] Create GitHub Actions workflow
- [ ] Trigger workflow on push and/or pull request
- [ ] Add compile step
- [ ] Add test step
- [ ] Add Docker image build step
- [ ] Fail pipeline when build or tests fail
- [ ] Push the generated docker image to Registry
- [ ] Document CI behavior in README

## EPIC 6: VM Deployment Baseline
- [ ] Define VM size and operating system for Linode
- [ ] Create VM manually for first validation
- [ ] Configure secure access
  - [ ] SSH key access
  - [ ] Disable password login if feasible
- [ ] Install required packages on VM
  - [ ] Docker
  - [ ] Docker Compose plugin or compose support
- [ ] Copy deployment files to VM
- [ ] Pull Docker image from Docker Hub
- [ ] Start application on VM using docker-compose
- [ ] Verify application is reachable from public IP
- [ ] Create update script
  - [ ] Stop current container(s)
  - [ ] Pull new image
  - [ ] Restart service
- [ ] Create restart/recovery notes

## EPIC 7: Basic Terraform for VM
- [ ] Create Terraform project structure for VM
- [ ] Configure Linode provider
- [ ] Define variables
  - [ ] region
  - [ ] VM type
  - [ ] image
  - [ ] SSH key
- [ ] Define VM resource
- [ ] Define firewall/security rules if included in scope
- [ ] Run `terraform fmt`
- [ ] Run `terraform validate`
- [ ] Test provisioning from clean state
- [ ] Document `init`, `plan`, `apply`, and `destroy`

## EPIC 8: Domain Setup
- [ ] Select domain or subdomain for the API
- [ ] Point DNS record to the VM public IP
- [ ] Verify DNS resolution
- [ ] Verify API is reachable through domain name
- [ ] Document DNS configuration steps

## EPIC 9: Documentation and Closure
- [ ] Complete `README.md`
  - [ ] Objective
  - [ ] Stack
  - [ ] How to run locally
  - [ ] How to run with Docker
  - [ ] How to run with docker-compose
  - [ ] How CI works
  - [ ] How to provision infrastructure
  - [ ] How to deploy to VM
  - [ ] How to access the API
  - [ ] Project limitations
- [ ] Add architecture notes
- [ ] Add backlog / future improvements section
- [ ] Verify MVP acceptance criteria
- [ ] Verify Definition of Done
- [ ] Tag first release (for example `v1.0.0`)

---

# Extension A: Basic Kubernetes Local

## EPIC A1: Local Kubernetes Setup
- [ ] Install Minikube or kind
- [ ] Create local Kubernetes cluster
- [ ] Verify cluster access with `kubectl`

## EPIC A2: Basic Kubernetes Manifests
- [ ] Create namespace if desired
- [ ] Create Deployment manifest
- [ ] Create Service manifest
- [ ] Create ConfigMap if needed
- [ ] Create Secret if needed
- [ ] Replace ambiguous “Mappings” with Ingress only if required for local path
- [ ] Organize manifests in `/k8s/local`

## EPIC A3: Local Kubernetes Validation
- [ ] Deploy manifests to local cluster
- [ ] Verify pods start successfully
- [ ] Verify service exposure works
- [ ] Test API from local Kubernetes environment
- [ ] Document local Kubernetes deployment steps

---

# Extension B: LKS Deployment

## EPIC B1: Managed Kubernetes Cluster
- [ ] Create LKS cluster manually for first validation
- [ ] Configure `kubectl` access to LKS
- [ ] Verify connection to cluster

## EPIC B2: Cloud Kubernetes Deployment
- [ ] Create environment-specific manifests for LKS
- [ ] Push image to registry accessible by cluster
- [ ] Deploy application to LKS
- [ ] Verify pod startup
- [ ] Verify service exposure
- [ ] Verify external access path
- [ ] Document LKS deployment steps

---

# Extension C: Terraform Expansion

## EPIC C1: Terraform for Kubernetes
- [ ] Extend Terraform structure for LKS resources
- [ ] Add variables for Kubernetes cluster configuration
- [ ] Create Terraform resources for LKS cluster
- [ ] Validate Terraform configuration
- [ ] Test apply/destroy flow

## EPIC C2: Terraform Structure Improvement
- [ ] Separate VM and Kubernetes modules or folders
- [ ] Define reusable variables and outputs
- [ ] Add environment-specific variable files if useful
- [ ] Document Terraform folder structure

---

# Extension D: Delivery Pipeline Expansion

## EPIC D1: CI Improvements
- [ ] Add Docker image scan step
- [ ] Add Docker Scout or similar scan
- [ ] Add image push step to Docker Hub
- [ ] Add branch/environment strategy notes

## EPIC D2: Simple CD for VM
- [ ] Create deployment workflow for VM
- [ ] Store deployment secrets in GitHub securely
- [ ] Trigger deployment manually or from selected branch
- [ ] Pull new image on VM
- [ ] Restart application automatically
- [ ] Verify deployment success

## EPIC D3: Simple CD for Kubernetes
- [ ] Create deployment workflow for Kubernetes
- [ ] Configure cluster credentials securely
- [ ] Apply manifests to target cluster
- [ ] Verify rollout success
- [ ] Document rollback basics if possible

---

# Extension E: TLS / SSL

## EPIC E1: TLS for VM
- [ ] Select TLS approach
  - [ ] Reverse proxy with certificate
  - [ ] Direct app termination only if intended
- [ ] Configure HTTPS for domain
- [ ] Verify certificate validity
- [ ] Verify secure access through HTTPS
- [ ] Document renewal/maintenance basics

## EPIC E2: TLS for Kubernetes
- [ ] Define TLS approach for LKS
- [ ] Configure ingress/controller or chosen entry point
- [ ] Attach certificate to domain routing
- [ ] Verify HTTPS access to Kubernetes deployment
- [ ] Document setup steps

---

# Backlog for Future Extensions (Not in Project 1)
- [ ] Observability with Prometheus and Grafana
- [ ] Kubernetes probes
- [ ] Resource requests and limits
- [ ] Horizontal Pod Autoscaler
- [ ] NetworkPolicy
- [ ] MySQL migration
- [ ] PostgreSQL migration
- [ ] Testcontainers
- [ ] Ansible for VM configuration
- [ ] Multi-cloud with DigitalOcean