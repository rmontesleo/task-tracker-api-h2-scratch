# Semantiec Versioning


##  1. Recommended approach: Semantic Versioning
The most comming simple convertion is Semantic Versioning:

`MAJOR.MINOR.PATCH`

Example:
- 1.0.0
- 1.1.0
- 1.1.1
- 2.0.0

Meaning:
- MAJOR = Significant redesign or breaking architectural change
- MINOR = new feature, backward-compatible or completed extension
- PATCH = bug fix, small improvement, non-breaking correction

### Example for the project

**Initial release**
1.0.0
Meaning
- MVP completed
- First official release

**Add basic Kuberntes extension**
1.1.0
Meaning
- New capability added
- Same base project

**Fix a deployment script bug**
1.1.1

**Add a second extension TLS extension**
1.2.0

**Large redesign, for example replacing H2 with MySQL and changing deployment model substantially**
2.0.0


## 2. Simple versioning rule for the project

Recommended rule:
- MVP complete -> 1.0.0
- each extension added -> increment **MINOR**
- small fixes -> increment **PATCH**
- major redesign/next generation of the project -> increment **MAJOR**

| Change | Suggested Version |
|--------|-------------------|
| MVP finished | 1.0.0 |
| Extension A: Basic Kubernetes | 1.1.0 |
| Extension B: LKS deployment | 1.2.0 |
| Extension C: Terraform expansion | 1.3.0 |
| Extension D: CI/CD expansion | 1.4.0 |
| Extension E: TLS/SSL | 1.5.0 |
| Small fix in README or deployment script | 1.5.1 |
| Mayour redesign for Project 2 | 2.0.0 |

## 3. Git tag examples
Use Git tags for releases

Recommended format:
- v1.0.0
- v1.1.0
- v1.1.0

**Example**
When the MVP is finished
- Create Git tag v1.0.0

When you finish Kubernetes extension:
- Create Git tag v1.1.0

## 4. Docker image tag examples
- task-api:1.0.0
- task-api:1.1.0
- task-api:1.1.1

Versioning tag + commig tag
Example
- task-api:1.0.0
- task-api:git-4f8c2d1

## 5. Banrching naming convention
Example:
- main
- feature/task-crud
- feature/docker-baseline
- feature/basic-k8s
- fix/docker-compose-port
- docs/readme-update

## 6. Documentation versioning
For planning docs, README, keep it simple, add small line 
- Document version: 1.0
- Last updated: 2026-04-01

## 7. Release Rules

### Git Tag
- MVP completion = `1.0.0`
- Each completed extension increments MINOR
- Fixes after a release incremetn PATCH
- Major redesign for the next generation of the project increments MAJOR

### Docker Image Tag
Docker images are tagged using the release versioning:
- `task-api:1.0.0`
- `task-api:1.1.0`
- `task-api:1.1.1`

### Examples
- MVP complete: `v1.0.0`
- Basic Kubernetes extension completee: `v1.1.0`
- Small deployment fix: `v1.1.1`
- TLS extension complete: `v1.2.0`
