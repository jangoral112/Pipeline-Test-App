pipeline {

    agent any

    stages {

        stage("build") {

            steps {
                sh "pwd"
                echo "Building the application..."
                sh "chmod 777 ./"
                sh "docker-compose -p pipeline_test -f docker/docker-compose.ci.yaml up -d"
                sh "docker-compose -f docker/docker-compose.ci.yaml down --remove-orphans"
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
    }
}