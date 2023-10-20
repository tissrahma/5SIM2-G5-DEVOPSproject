node {
    stage('Preparation') {
        deleteDir()  // Delete the workspace before the build starts
    }

    // Move the pipeline block outside the node block
    // Define the pipeline stages here
}

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
                   sh 'mvn -f /var/lib/jenkins/workspace/ProjetSpring/DevOps_Project/pom.xml clean test'
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
