pipeline {
    agent any
    environment {
        POM_FILE = 'ProjetSpring1/pom.xml'
    }
    stages {
        stage('Testing maven') {
            steps {
                echo 'hhhhhhhhh'
            }
        }
        stage('Test') {
            steps {
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
