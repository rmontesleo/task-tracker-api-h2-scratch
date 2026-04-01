# Git versioning conventions

Keep it simple:
- one main branch
- feature branches
- semantic versioning
- release tag

## 1. Simple Git workflow
Branching model
- main -> stable branch
- feature/... -> new work
- fix/... -> bug fixes
- docs/... -> documentation-only changes

Examples:
- feature/task-crud
- feature/docker-baseline
- feature/vm-deployment
- feature/basic-k8s
- fix/docker-compose-port
- docs/readem-project-scope

## 2. Create the repository and first commit
```bash
git init
git add .
git commit -m "chore: initial structure"
git branch -M main

# Add remote repo
git remote add origin git@github.com:rmontesleo/task-tracker-api-h2-scratch.git
git push -u origin main
```

## 3. Create a feature branch
```bash
# start the CRUD API  to work in brnah feature/branch
git checkout main
git pull origin main
git checkout -b feature/task-crud

# after work in branch
git add .
git commit -m "feat: implement task CRUD API"
git push -u origin feature/task-crud

# then merge into main on locally
git checkout main
git pull origin main
git merge feature/task-crud
git push origin main

# Then optionally delete the branch
git branch -d feature/task-crud
git push origin --delete feature/task-crud

```

## 4. Example branch sequence for this project, a practical order
```bash
main
feature/project-setup
feature/task-crud
feature/h2-config
feature/unit-tests
feature/docker-baseline
feature/github-actions-ci
fetaure/linode-vm-deployment
feature/terraform-vm
feature/domain-setup
feature/basic-k8s
feature/lks-deployment
feature/tls-extension
```

## 5. How to version the project
Use Semantic Versioning:
```text
MAJOR.MINOR.PATCH
```

Examples
- 1.0.0
- 1.1.0
- 1.1.1

Meaning
- MAJOR = big redesign or breaking change
- MINOR = new feature or extension
- PATCH = small fix

## 6. Samples versioning for the project
```bash
v1.0.0 -> MVP complete
v1.1.0 -> Extension A: Basic Kubernetes
v1.2.0 -> Extension B: LKS deployment
v1.3.0 -> Extension C: Terraform expansion
v1.4.0 -> Extension D: CI/CD expansion
v1.5.0 -> Extension E: TLS/SSL
v1.5.1 -> small bug fix
```

## 7. How to create tags

Example: When finish a release, create a tag MVP is complete
```bash
git checkout main
git pull origin main
git tag -a v1.0.0 -m "Release v1.0.0 - MVP complete"
```

## 8. How to see tags
```bash
git tag

# to see one specific tag
git show v1.0.0
```

## 9. How to create the next relase tag
```bash
# example: after Basic Kuberntes extension
git checkout main
git pull origin main
git tag -a v1.1.0 -m "Release v1.1.0 - Basic Kubernetes extension"
git push origin v1.1.0
```

## 10. Example full flow

### Step A: stark Docker work
```bash
git checkout main
git pull origin main
git checkout -b feature/docker-baseline
```

### Step B: commit work
```bash
git add .
git commit -m "feat: add multi-stage Dockerfile and docker-compose"
git push -u origin feature/docker-baseline
```

### Step C: merge to main
```bash
git checkout main
git pull origin main
git merge feature/docker-baseline
git push origin main
```

### Step D: create release tag
```bash
# if this complete the MVP
git tag -a v1.0.0 -m "Release v1.0.0 - MVP complete"
git push origin v1.0.0
```

## 11. Suggested commit message style
A simple convention:
- feat: new functionality
- fix: bug fix
- docs: documentation
- refactor: code cleanup
- test: tests
- chore: setup or maintenance

Examples:
- feat: implement task CRUD API
- feat: add Swagger configuration
- fix: correct docker-compose port mapping
- docs: update README with VM deployment steps
- test: add service and controller unit tests
- chore: add GitHub Actions workflow

## 12. Example release history for this project
```bash
v0.1.0 Initial projexct skeleton
v0.2.0 CRUD API working locally
v0.3.0 Docker and docker-compose added
v0.4.0 Basic CI pipeline added
v1.0.0 MVP complete
v1.1.0 Basic Kubernetes extension
v1.2.0 LKS deployment
v1.3.0 Terraform dexpansion
v1.4.0 CI/CD deployment extension
v1.5.0 TLS/SSL extension
```

* This is usful if some pre-release progress before th MVP

## 13. Docker image version examples
```bash
# for this project docker hub user is rmontesleo
docker_hub_user=rmontesleo

docker build -t $docker_hub_user/task-api:1.0.0 .
docker push $docker_hub_user/task-api:1.0.0

# optional convenience tag
docker tag $docker_hub_user/task-api:1.0.0 $docker_hub_user/task-api:latest
docker push $docker_hub_user/task-api:latest
```

## 14. A very practical workflow
**Branches**
- main
- feature/...
- fix/...
- docs/...

**Versions**
- v1.0.0 for MVP
- each extension increments minor 

**Tags**
Create annotated tags only on main

## 15 Sample commands cheat sheet
```bash
# create branch
git chekout -b  feature/task-crud

# commit changes
git add .
git commit -m "feat: implement task CRUD API"

# push branch
git push -u origin feature/task-crud

# merge into main
git checkout main
git pull origin main
git merge featrue/task-crud
git push origin main

# create release tag
git tag -a v1.0.0 -m "Release v1.0.0 - MVP complete"

# list tags
git tag

# instpect tag
git show v1.0.0

```

## 16. Recommendations sample for Project 1 
```bash
# Branches:
main
feature/task-crud
feature/docker-baseline
feature/github-actions-ci
feature/linode-vm
feature/terrform-vm
feature/domain-setup
feature/basic-k8s

# Versions:
v1.0.0 -> MVP
v1.1.0 -> Basic Kubernetes
v1.2.0 -> LKS
v1.3.0 -> Terraform expansion
v1.4.0 -> CI/CD extension
v1.5.0 -> TLS

# Commit examples:
feat: implement task CRUD API
feat: add Docker baseline
feat: add VM deployment scripts
docs: update README with deployment steps
fix: correct Terraform variable naming

```


| Feature / Extension | New Release Tag? | Example Tag |
|---|---|---|
| MVP complete (baseline CRUD + H2 + Docker + CI + VM) | yes | `v1.0.0` |
| Extension A: Basic Kubernetes local | yes | `v1.1.0` |
| Extension B: LKS managed Kubernetes | yes | `v1.2.0` |
| Extension C: Terraform expansion | yes | `v1.3.0` |
| Extension D: CI/CD pipeline expansion | yes | `v1.4.0` |
| Extension E: TLS/SSL deployment | yes | `v1.5.0` |
| Minor docs/README clarification | no (patch only maybe) | `v1.5.1` |
| Small bugfix (behavior fix) | yes (patch) | `v1.5.1` |

