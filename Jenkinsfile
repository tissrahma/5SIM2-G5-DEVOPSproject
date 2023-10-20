pipeline {
    agent any
    stages {
        stage('Testing maven') {
            steps {
                echo 'Running Maven clean and test'
                sh 'mvn -f /var/lib/jenkins/workspace/ProjetSpring1/DevOps_Project/pom.xml clean test'
            }
        }
    }
    post {
        always {
            junit '*/target/surefire-reports/**/.xml'
        }
    }
}
