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
                try {
                  sh ./gradlew clean test --no-daemon
                } finally {
                  junit "**/build/test-results/test/*.xml"
                }
            }
        }

        stage("deploy") {

            steps {
                echo "deploying the application..."
            }
        }
    }
}