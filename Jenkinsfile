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

    stage('Checkout from GitHub') {
        steps {
            script {
                // Cloner le référentiel GitHub en spécifiant l'URL
                checkout([$class: 'GitSCM', branches: [[name: 'moemenkhitem']], userRemoteConfigs: [[url: 'https://github.com/tissrahma/5SIM2-G5-DEVOPSproject']]])
            }
        }
    }

    stage('Maven Clean') {
        steps {
            sh 'mvn -f /var/lib/jenkins/workspace/ProjetSpring1/DevOps_Project/pom.xml clean'
        }
    }

    stage('Maven Compile') {
        steps {
            sh 'mvn -f /var/lib/jenkins/workspace/ProjetSpring1/DevOps_Project/pom.xml compile'
        }
    }

    stage('MVN SONARQUBE') {
        steps {
            script {
                sh 'mvn -f /var/lib/jenkins/workspace/ProjetSpring1/DevOps_Project/pom.xml sonar:sonar -Dsonar.login=sqa_82474f4c295c337e9a7ce8fd0df4ce489beca4bc'
            }
        }
    }

    stage('JUNIT/MOCKITO') {
        steps {
            script {
                sh 'mvn -f /var/lib/jenkins/workspace/ProjetSpring1/DevOps_Project/pom.xml clean test'
            }
        }
    

   

  post {
       always {
                    
            junit '**/target/surefire-reports/**/*.xml'
}
    }
}