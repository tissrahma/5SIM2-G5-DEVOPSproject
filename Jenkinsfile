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
                           checkout([$class: 'GitSCM', branches: [[name: 'RAHMA']], userRemoteConfigs: [[url: 'https://github.com/tissrahma/5SIM2-G5-DEVOPSproject']]])
                       }
                   }
               }

            stage('Maven Clean') {
                  steps {

                      sh 'mvn -f /var/lib/jenkins/workspace/ProjetSpring/DevOps_Project/pom.xml clean'
                  }
              }

              stage('Maven Compile') {
                  steps {

                      sh 'mvn -f /var/lib/jenkins/workspace/ProjetSpring/DevOps_Project/pom.xml compile'
                  }
              }
       

        stage('JUNIT/MOCKITO') {
            steps {

                script {
                   sh 'mvn -f /var/lib/jenkins/workspace/ProjetSpring/DevOps_Project/pom.xml clean test'
            }
            }
        }
           
    }
  post {
       always {
                    
            junit '**/target/surefire-reports/**/*.xml'

                }
    }
}