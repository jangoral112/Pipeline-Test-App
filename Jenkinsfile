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
        }

        success {
            echo "1235"
            sh "curl -XPOST http://elastic/jenkins_data/_doc?pretty -d {
                  \"timestamp\": \"2015-01-01T12:10:30Z\",
                  \"build_status\": \"success\"
            }"
        }

        failure {
            echo "1234"
            sh "curl -XPOST http://elastic/jenkins_data/_doc?pretty -d {
                  \"timestamp\": \"2015-01-01T12:10:30Z\",
                  \"build_status\": \"failure\"
            }"
        }
    }
}