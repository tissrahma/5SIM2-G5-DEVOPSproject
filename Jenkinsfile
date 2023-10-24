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
                           checkout([$class: 'GitSCM', branches: [[name: 'khitem5Sim2']], userRemoteConfigs: [[url: 'https://github.com/tissrahma/5SIM2-G5-DEVOPSproject']]])
                       }
                   }
               }

            stage('Maven Clean') {
                  steps {

                      sh 'mvn -f /var/lib/jenkins/workspace/DevopsSpring/ProjetSpring1/pom.xml clean'
                  }
              }

              stage('Maven Compile') {
                  steps {

                      sh 'mvn -f /var/lib/jenkins/workspace/DevopsSpring/ProjetSpring1/pom.xml compile'
                  }
              }
              stage('MVN SONARQUBE') {
                  steps {
                      script {

                          sh 'mvn -f /var/lib/jenkins/workspace/DevopsSpring/ProjetSpring1/pom.xml sonar:sonar -Dsonar.login=sqa_2d7e848a8687bd061c7a33b7b6f5768a0aab3aa3'
                      }
                  }
              }

        stage('JUNIT/MOCKITO') {
            steps {

                script {
                   sh 'mvn -f /var/lib/jenkins/workspace/DevopsSpring/ProjetSpring1/pom.xml clean test'
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