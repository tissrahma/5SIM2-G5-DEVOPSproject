pipeline {
    agent any
    environment {
        POM_FILE = 'ProjetSpring1/pom.xml'
    }
    stages {
        stage('Verify POM File') {
            steps {
                script {
                    // Check if the POM file exists
                    if (fileExists("${POM_FILE}")) {
                        echo "POM file exists: ${POM_FILE}"
                    } else {
                        error "POM file does not exist: ${POM_FILE}"
                    }
                }
            }
        }
        stage('Build and Test') {
            steps {
                // Build and test steps (assuming the POM file exists)
                sh "mvn -f ${POM_FILE} clean test"
            }
        }
    }
    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }
    }
}
