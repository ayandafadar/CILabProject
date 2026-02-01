# CILabProject

Jenkins CI lab project with Freestyle and Multibranch Pipeline job support.

## Repository Structure

```
CILabProject/
├── src/
│   ├── main/
│   │   ├── java/com/muj/ci/Calculator.java
│   │   └── resources/
│   └── test/
│       └── java/com/muj/ci/CalculatorTest.java
├── pom.xml
├── Jenkinsfile
├── docker/
│   └── Dockerfile
├── scripts/
│   ├── build.sh
│   ├── build.bat
│   ├── deploy.sh
│   └── deploy.bat
└── README.md
```

## Jenkins Job Notes

### Freestyle Project

- SCM: GitHub repository
- Triggers: Poll SCM + webhook
- Build Steps: run build script and tests
	- Windows: `scripts\\build.bat` and `mvn -q test`
	- Linux/macOS: `scripts/build.sh` and `mvn -q test`
- Post-build: archive `target/*.jar`, publish JUnit reports from `target/surefire-reports/*.xml`

### Multibranch Pipeline

The Jenkinsfile implements branch-based strategies:

- `main`: build, test, and deploy
- `feature/*`: build and test only
- `release/*`: build, test, and archive
