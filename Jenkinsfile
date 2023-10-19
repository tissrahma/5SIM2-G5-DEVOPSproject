pipeline {
    agent any
    stages {
        stage('Testing maven') {
            steps {
                echo 'hhhhhhhhh'
            }
        }
        stage('Test') {
            steps {
                // Specify the path to your pom.xml
              sh 'mvn -f /var/lib/jenkins/workspace/ProjetSpring/5SIM2-G5-DEVOPSproject/DevOps_Project/pom.xml clean test'
           }
        }
    }
    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }
    }
}