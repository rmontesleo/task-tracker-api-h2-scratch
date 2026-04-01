# Project 1 Planning - Delivery Baseline for the DevOps/DevSecOps Phase

## Content Table

1. [Document Control](#1-document-control)
2. [Document History](#2-document-history)
3. [Project Context](#3-project-context)
4. [Audience](#4-audience)
5. [Objective](#5-objective)
6. [Success Statement](#6-success-statement)
7. [Scope](#7-scope)
8. [Assumptions and Constraints](#8-assumptions-and-constrains)
9. [Selected Stack](#9-selected-stack)
10. [Architecture / Technical Rules](#10-architecture--technical-rules)
11. [Delivery Strategy](#11-delivery-strategy)
12. [MVP Definition](#12-mvp-definition)
13. [Extensions](#13-extensions)
14. [Definition of Done](#14-definition-of-done)
15. [Milestones](#15-milestones)
16. [Risks and Mitigations](#16-risks-and-mitigations)
17. [Backlog / Future Increments](#17-backlog--future-increments)
18. [Appendix](#18-appendix)
19. [Writing Checklist](#19-writing-checklist)

## 1. Document Control
- **Project Name:** Task API Delivery Baseline
- **Version:** 1.0
- **Owner:** Leopoldo Ramirez Montes
- **Portfolio Phase:** Phase 1 - DevOps/DevSecOps
- **Primary Cloud Target:** Akamai Linode

## 2. Document History

| Last Updated | Author | Status | Notes |
|---|---|---|---|
| 2026-03-30 | Leopoldo | STARTED | Initial project planning document created |
| 2026-03-31 | Leopoldo | DONE | Reviwew and approved planning and Breadk down  |
|  |  |  |  |
|  |  |  |  |


## 3. Project Context
This project is the first foundation block in a portfolio roadmap aimed at becoming a Software Architect with strong hands-on expertice across DevOps/DevSecOps, modern Java backend development, AI Engineering, and Frontend/UX support.

The project uses a simple Task CRUD API as a vehicle to practice application structure, containerization, infrastructure provisioning, cloud deployment, and basic Kubernetes exposure. The business domain is intentionally simple so the main learning focus stay on delivery, deployment, and engineering discipline rather the domain complexity.

This project must create a reusable baseline that later project can extend with stronger database patterns, deeper Kubernetes capabilities, observability, improved security controls, and more advanced deployment strategies.

## 4. Audience
This document is intended for:
- The project owner as a planning and scope-control reference
- Future-you as a reusable execution template
- Reviewers, interviewers or mentors who want to understand project intent and boundaries
- Anyone reviewing the repository and project documentatioin


## 5. Objective
Build a Spring Boot Task CRUD API that can run locally, in Docker, and on a Linode VM, with a basic Kubernetes deployment path, basic CI automation, and Terraform-managed infrastructure as the first delivery baselilne for future portfolio projects.

## 6. Success Statement
This project is successful when it proves and end-to-end delivery path for a simple Java service: local execution, containerization, infrastructure provisioning, basic cloud deployment, and repeatable documentation. This project is not meant to be production-grade in every dimension; it is meant to establish a clean an finishable baseline that futrue projects can strengthen incrementally.


## 7. Scope

### 7.1 In Scope
- SpringBoot Task CRUD API
- H2 Database for simplicity in the first version
- Layered architecture with controllers, services, repositories, entities, DTOs, and configuration
- Exception handling and basic validations
- OpenAPI/Swagger
- Unit Testing for main application layers
- Dockerfile with multi-stage Docker build
- docker-compose for local execution
- Basic GitHub Actions CI workflow
- Terraform for minimum infrastructure required for the primary cloud target
- Deployment on Linode to one Virtual Machine
- Running appliction using dockere-compose
- One public domain or subdomain for the primary deployment target
- Basic Kubernetes deployment path for learning and demostration
- README and MIT Licence files


### 7.2 Out of Scope
- Advance Kubernetes capabilities such as autoscaling, networking policy, or production-grade release strategies
- Monitoring and Observability stack (Prometheus, Grafana, alerting, distributed traicing)
- Production-grade persistent datase like MySQL or PostgreSQL
- Multicloud deployment
- Full automatic CD to all deployment targets
- Security Scanning tools like Sonnarqube, Snyk, Trivy
- Advanced DevSecOps supply-chain controls
- Authentication/Authorization
- User management
- Frontend UI
- Microservices, messages Queues or event-driven architectures
- Performance Testing

## 8. Assumptions and Constrains

### 8.1 Assumptions
- The proeject owner wants a finishable first baseline, not a production-complete platform
- A simple CRUD domain is enough for the first delivery baseline
- Kubernetes exposure is useful in Project 1, but deep Kubernetes matury will come later
- Linode is the primary cloud target for this versions

### 8.2 Constrains
- Scope must stay small enough to complete without turning into a long-running platform project
- The first version should be optimize for learning and completion, not maximum feature depth
- H2 is intentionally temporary and will be replaced in later projects
- Only one main deployment target is required for the MVP completion


### 9. Selected Stack
- **Programming Language**: Java 25 
- **Framework**: SpringBoot 4
- **Database**:H2 Database
- **Containers**: Docker, docker-compose
- **Cloud**: Akamai Linode
- **Kubernetes**: Minikube (Local development), LKS (basic path)
- **Infrastructure as Code** :Terraform
- **Reverse Proxy**: Nginx
- **TSL Certificate Client***: Certbot
- **TSL Certificate Provider** : Let's Encrypt
- **Documentation**: Markdown, README
- **Licence**: MIT


## 10. Architecture / Technical Rules
- Use a layered application structure: controller, service, repository, entity, DTO, configuration, mappers
- Separate DTOs from entities
- Keep business logic in services
- Handle HTTP and exception concerns in controllers
- Externalize configuration where appropiate
- Use H2 only for the first version to resuce early operational complexity
- Keep the first version single-service
- Prefere repeatable provisionin and deployment steps over manual and hoc setup
- Move non-MVP ideas to backlog instad of absorbing them into current scope


## 11. Delivery Strategy
**Chosen strategy**: MVP + extensions

This strategy is preferred over a fully mandatory multi-phase delivery because it creates a clear finish line. The project will be considered complete once the MVP is done. Extensions are valuable, but they are optional for version 1 and can become later increments or reparated project if needed.

## 12. MVP Definition
Deliver the smallest valuable version of the project that proves the end-to-end delivery baseline: application structure, local execution, containerization, CI, basic infrastructure provisioning, VM deployment, and access through a domain.

### 12.1 MVP Deliverables
- Working Task CRUD API
- Local run path with Spring Boot
- Docker image and docker-compose local run path
- Basic GitHub Actions CI
- Terraform for basic VM-related infrastructure
- Domain name pointing to the deployed API
- Updated README and MIT licence

### 12.2 MVP Acceptance Criteria

#### 12.2.1 Application
- The API supports create, get all, get by id, update and delte operations for tasks.
- Successful operations return expected HTTP status codes
- Invalid input returns a client error response
- Not-found request return 404
- OpenAPI/Swagger UI is available

#### 12.2.2 Local Executions
- The application starts locally through Spring Boot
- The application starts locally through Docker
- The application starts locally through docker-compose

#### 12.2.3 CI 
- A GitHub Actions workflow runs automatically on push and/or pull request
- The workflow compiles the application
- The workflow runs unit test
- The workflow builds the Docker image
- The workflow fails when compilation or tests fails
- THe workflow push the Docker image in the selected Registry

#### 12.2.4 Infrastructure
- Terraform provisions the minimum infrastructure required for the primary deployment target
- Terraform uses variables for key environment values
- Infrastructure creation steps are documented
- Infrastructure destroy steps are documented

#### 12.2.5 VM Deployment
- The application is deployed to one Linode VM
- The API is reachable from outside the VM
- Deployment uses the documentd deployment paht consistenly
- Host access uses SSH key-based access

#### 12.2.6 Domain
- A domain or subdomain points to the deployed API
- The API can be reached through the domain name, not only through a row IP address

#### 12.2.7 Documentation
- The README explains how to run locally, build the image, provision the infrastructure, deploy the application, and access the API
- Version limitations are documented

### 12.3 MVP Verification
The MVP is verified when a reviewer can:
1. Read teh planning document and README
2. Read the application locally
3. Run the application with Docker/docker-compose
4. See a pasing CI workflow
5. The new docker image is publish on registry
6. Provision or review the Terraform baseline
7. Confirm the VM deployment is reachable by domain name

### 12.4 MVP Risks
- DNS and cloud configurationmay add friction unrelated to applicaiton logic
- Terraform may take longer than expected if provider setup is new
- CI and deployment steps can expand in complexity if not kept basic

## 13. Extensions

### Extension A - Basic Kubernetes Local Deployment
**Objective**
- Demostrate the application running on a local Kubernetes environment for learning purposes.

**Scope**
- Create basic manifest for Deployment and Service
- Deploy to Minikube or equivalent local Kubernetes runtime
- Document the local Kubernetes run paht

**Acceptance Criteria**
- Deployment and Service manifest exist
- The application deploys successfully to the local Kubernetes environment
- The application can be reached and tested from the local environment
- The deployment steps are documented

**Deferred**
- Autoscaling
- Network policies
- Advanced probes
- Helm or Kustomize sophistication

### Extension B - Basic Managed Kubernetes Deployment
**Objective**
- Demostrate that the same application can run on managed Kubernetes in the Cloud

**Scope**
- Adapt basic manifests for LKS
- Pull the image from the intended registry
- Expose the application through a simple network path

**Acceptance Criteria**
- The application deploys successfully to LKS
- The deployed application is reachable through the expected access path
- The image is pulled from the intended registry
- The steps are documented

**Defered**
- Production-grade ingress strategy
- Autoscaling
- Observabilty
- Security hardening beyond basic secrets/configuration


### Extension C - Simple CD
**Objective**
- Reduce manual deployment effort without overenginerring the release flow

**Scope**
- Add a deployment workflow in GitHub Actions
- Support controlled or manual-trigger deployment for the chosen target

**Acceptance Criteria**
- A deployment workflow exists
- The worflow can deploy a new version to the chosen target environment
- The workflow uses controlled credentials or environment secrets
- The deployed version can be verified

**Deferred**
- Complex release promotion
- Multiple environment gates
- Full rollback automation

### Extension D - TLS / SSL
**Objective**
- Improve the public-facing deployment with HTTPS

**Scope**
- Configure TLS for the public deployment target
- Document certificate and DNS setup

**Acceptance Criteria**
- The API is reachable through HTTPS
- The certificat is valid for the chosen domain
- TLS setup steps are documented

**Defered**
- Multi-target TLS
- Advanced certificate automation patterns

## 14. Definition of Done
Project 1 is done when:
- all MVP acceptance criteria are satisfied
- the Task CRUD API works locally
- the CI workflow runs successfully
- Terraform defines the baseline infrastructure
- the application is deployed to one Linode VM
- the domain points to the deployed API
- the README is complete
- the MIT license is included
- and all non-MVP ideas are explicitly moved to the backlog, future extensions, or later projects.

Extension are valuable but not required for Project 1 to be considered complete.


## 15. Milestones

| Milestone | Goal | Main Outputs | Exit Criteria |
|---|---|---|---|
| M1 | Build the application baseline | Spring Boot project, CRUD endpoints, DTOs, service, repository, tests, Swagger | CRUD works locally and tests pass |
| M2 | Package and automate local delivery | Dockerfile, docker-compose, CI workflow | Image builds, compose runs, CI passes |
| M3 | Provision and deploy baseline cloud target | Terraform baseline, Linode VM deployment, domain setup | API is reachable on the VM through the domain |
| M4 | Optional Kubernetes extension | Basic manifests and local or LKS deployment | App is demonstrated on Kubernetes with documented steps |
| M5 | Optional delivery hardening | Simple CD and/or TLS | Optional extension acceptance criteria are satisfied |

## 16. Risks and Mitigations

| Risk | Impact | Mitigation |
|---|---|---|
| Project scope grows too fast | Delayed completion | Keep MVP small and move ideas to backlog |
| Cloud setup consumes too much time | Slows progress | Treat VM as the primary target and make K8s optional |
| Kubernetes complexity distracts from MVP | Project stalls | Keep Kubernetes as extension, not hard requirement |
| DNS / TLS adds friction | Delays public exposure | Make TLS optional for version 1 |
| H2 limitations create architecture concerns | Misaligned expectations | Document H2 as intentionally temporary |

## 17. Backlog / Future Increments
| Item | Why Deferred | Target Phase / Project |
|---|---|---|
| Replace H2 with MySQL or PostgreSQL | Requires persistence and data lifecycle decisions | Project 2 |
| Add Testcontainers | Better aligned after real database is introduced | Project 2 |
| Add Prometheus and Grafana | Observability is a later maturity step | Project 2 or 3 |
| Add Kubernetes probes, resource limits, HPA | Better after baseline deployment is stable | Project 2 or 3 |
| Add NetworkPolicy and stronger K8s security context | Part of deeper Kubernetes maturity | Project 3 |
| Add multi-cloud with DigitalOcean | Too wide for the first project | Project 3+ |
| Add advanced DevSecOps controls | Better after baseline delivery is proven | Project 3+ |

## 18. Appendix

### Task API Response Codes
| Endpoint | Method | Success Code | Notes |
|---|---|---|---|
| /api/tasks | POST | 201 | Create task |
| /api/tasks | GET | 200 | Get all tasks |
| /api/tasks/{id} | GET | 200 | Get task by id |
| /api/tasks/{id} | PUT | 200 | Update task |
| /api/tasks/{id} | DELETE | 204 | Delete task |
| /api/tasks/{id} | GET / PUT / DELETE | 404 | Resource not found |
| /api/tasks | POST / PUT | 400 | Invalid request payload |

### Environment Summary
| Environment | Purpose | Notes |
|---|---|---|
| Local Spring Boot | Fast development loop | Primary development path |
| Docker local | Container validation | Confirms packaging works |
| docker-compose local | Local service orchestration | Used for repeatable local execution |
| Linode VM | Primary cloud deployment target | Part of MVP |
| Local Kubernetes | Learning / validation path | Extension A |
| LKS | Managed Kubernetes exposure | Extension B |


## 19. Writing Checklist
- [x] Context explains why the project exists
- [x] Audience is identified
- [x] Objective is outcome-focused
- [x] Scope and out-of-scope are explicit
- [x] MVP is small and finishable
- [x] Each extension has objective and acceptance criteria
- [x] Definition of Done is explicit
- [x] Risks and deferred items are documented
- [x] The document can guide future implementation and README updates