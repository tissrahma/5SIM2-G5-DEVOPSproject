pipeline {
    agent any
    stages {
        stage('Testing maven') {
            steps {
                echo 'hhhhhhhhh'
            }
        }
        stage('JUNIT/MOCKITO') {
            steps {
                // Specify the path to your pom.xml
                script {
                   sh 'mvn -f /var/lib/jenkins/workspace/ProjetSpring1/DevOps_Project/pom.xml clean test'
            }
            }
        }
    }
  post {
        always {
            junit '*/target/surefire-reports/.xml'
        }
    }
}