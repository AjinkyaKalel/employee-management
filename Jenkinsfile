pipeline {
    agent any

    tools {
        jdk 'JDK17'
        maven 'Maven3'
    }

    stages {
        stage('Checkout') {
            steps {
                // Jenkins retrieves the source from the GitHub repository configured for this job.
                checkout scm
            }
        }

        stage('Compile') {
            steps {
                sh 'mvn -B clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn -B test'
            }
        }

        stage('Build Verification') {
            steps {
                sh 'mvn -B package'
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true, allowEmptyArchive: true
        }
        success {
            echo 'BUILD SUCCESSFUL: compilation, tests and packaging passed.'
        }
        failure {
            echo 'BUILD FAILED: check the stage logs for errors.'
        }
    }
}
