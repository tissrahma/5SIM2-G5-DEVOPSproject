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
                // Specify the path to your pom.xml using double quotes
                script {
                    sh "mvn -f /var/lib/jenkins/workspace/ProjetSpring/DevOps_Project/pom.xml clean test"
                }
            }
        }
    }
    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }
    }
}
