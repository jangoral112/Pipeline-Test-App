pipeline {

    agent any

    stages {

        stage("build") {

            steps {
                sh "pwd"
                echo "Building the application..."
                sh "chmod 777 ./"
                sh "docker-compose -p pipeline_test -f docker/docker-compose.ci.yaml up -d"
                sh "docker rm -f service_a"
                sh "docker network rm app_network"
            }
        }

        stage("test") {

            steps {
                echo "testing the application..."
            }
        }

        stage("deploy") {

            steps {
                echo "deploying the application..."
            }
        }
    }
    post {
        always {
            cleanWs()
        }

        success {
            script {
              sh "echo success"
            }
        }

        failure {
            script {
              sh "echo failure"
            }
        }

        unstable {
            script {
              sh "echo unstable"
            }
        }

        aborted {
            script {
              sh "echo aborted"
            }
        }

    }
}