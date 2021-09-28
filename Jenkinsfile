pipeline {

    agent any

    stages {

        stage("build") {

            steps {
                echo "building the application..."
            }
        }

        stage("test") {

            steps {
                junit "**/build/test-results/test/*.xml"
            }
        }

        stage("deploy") {

            steps {
                echo "deploying the application..."
            }
        }
    }
}