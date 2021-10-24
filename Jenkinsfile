pipeline {

    agent any

    stages {

        stage("test build") {

            steps {
                sh "pwd"
                echo "Building the application..."
                sh "chmod 777 ./"
                sh "printenv"
                sh "docker-compose -p pipeline_test -f docker/docker-compose.ci.yaml up -d"
                sh "docker-compose -p pipeline_test -f docker/docker-compose.ci.yaml down"
            }
        }

        stage("test") {

            steps {
                echo "testing the application..."
                script {
                    def val = Math.random()
                    echo "${val}"
                    assert val > 0.5 : "Build failed because of random"
                }
            }
        }

        stage("print env") {

            steps {
                sh "printenv"
            }
        }
    }

    post {
        always {
            script {
                def now = new Date()
                def formattedTimestamp = now.getTime()
                println formattedTimestamp
                DEPLOY_TIMESTAMP = formattedTimestamp
            }
            cleanWs()
            echo "5678"
        }

        success {
            echo "1235"
            echo "$DEPLOY_TIMESTAMP"
            echo "$BRANCH_NAME"
            sh "curl --location --request POST 'http://devops-kpi-chapter1_elastic_1:9200/jenkins_data/_doc?pretty' --header 'Content-Type: application/json' --data-raw '{\"timestamp\": \"${DEPLOY_TIMESTAMP}\",\"build_status\": \"success\"}'"
        }

        failure {
            echo "1234"
            echo "$DEPLOY_TIMESTAMP"
            echo "$BRANCH_NAME"
            sh "curl --location --request POST 'http://devops-kpi-chapter1_elastic_1:9200/jenkins_data/_doc?pretty' --header 'Content-Type: application/json' --data-raw '{\"timestamp\": \"${DEPLOY_TIMESTAMP}\",\"build_status\": \"failure\"}'"
        }
    }
}