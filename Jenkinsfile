pipeline {

    agent any

    stages {

        stage("test build") {

            steps {
                sh "pwd"
                echo "Building the application..."
                sh "chmod 777 ./"
                sh "docker-compose -p pipeline_test -f docker/docker-compose.ci.yaml up -d"
                sh "docker-compose -p pipeline_test -f docker/docker-compose.ci.yaml down"
            }
        }

        stage("test") {

            steps {
                echo "testing the application..."
                script {
                  assert Math.random() > 0.5 : "Build failed because of random"
                }
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
            echo "5678"
        }

        success {
            echo "1235"
        }

        failure {
            echo "1234"
        }
    }
}