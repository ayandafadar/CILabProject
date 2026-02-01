pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    stages {
        stage('Build') {
            steps {
                script {
                    if (isUnix()) {
                        sh 'scripts/build.sh'
                    } else {
                        bat 'scripts\\build.bat'
                    }
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    if (isUnix()) {
                        sh 'mvn -q test'
                    } else {
                        bat 'mvn -q test'
                    }
                }
            }
        }
        stage('Main Strategy') {
            when {
                branch 'main'
            }
            steps {
                echo 'Main branch: run deploy workflow.'
                script {
                    if (isUnix()) {
                        sh 'scripts/deploy.sh'
                    } else {
                        bat 'scripts\\deploy.bat'
                    }
                }
            }
        }
        stage('Feature Strategy') {
            when {
                branch 'feature/*'
            }
            steps {
                echo 'Feature branch: build and test only.'
            }
        }
        stage('Release Strategy') {
            when {
                branch 'release/*'
            }
            steps {
                echo 'Release branch: package and archive.'
            }
        }
    }
    post {
        always {
            junit testResults: 'target/surefire-reports/*.xml', allowEmptyResults: true
            archiveArtifacts artifacts: 'target/*.jar', onlyIfSuccessful: false
        }
    }
}
