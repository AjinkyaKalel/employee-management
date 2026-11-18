
pipeline {
    agent any

    tools {
        jdk 'JDK17'
        maven 'Maven3'
    }

    stages {
        stage('Compile') {
            steps {
                bat 'mvn -B clean compile'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn -B test'
            }
        }

        stage('Build Verification') {
            steps {
                bat 'mvn -B package'
            }
        }
    }

    post {
        always {
            junit allowEmptyResults: true,
                  testResults: 'target/surefire-reports/*.xml'

            archiveArtifacts artifacts: 'target/*.jar',
                             fingerprint: true,
                             allowEmptyArchive: true
        }

        success {
            echo 'BUILD SUCCESSFUL!'
        }

        failure {
            echo 'BUILD FAILED! Check the console output.'
        }
    }
}
