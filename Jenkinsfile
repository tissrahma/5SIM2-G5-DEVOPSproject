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

                      sh 'mvn -f /var/lib/jenkins/workspace/ProjetSpring1/DevOps_Project/pom.xml clean'
                  }
              }
 		
              stage('Maven Compile') {
                  steps {

                      sh 'mvn -f /var/lib/jenkins/workspace/ProjetSpring1/DevOps_Project/pom.xml compile'
                  }
              }
	        stage('Build') {
 tools {
        jdk "jdk11" // the name you have given the JDK installation using the JDK manager (Global Tool Configuration)
    }
    steps {
        sh 'mvn compile'
    }
}
stage('SonarQube analysis') {
    tools {
        jdk "jdk17" // the name you have given the JDK installation using the JDK manager (Global Tool Configuration)
    }
    environment {
        scannerHome = tool 'SonarQube Scanner' // the name you have given the Sonar Scanner (Global Tool Configuration)
    }
    steps {
        withSonarQubeEnv(installationName: 'SonarQube') {
            sh 'mvn sonar:sonar'
        }
    }
}
              stage('MVN SONARQUBE') {
                  steps {
                      script {
                          sh 'mvn -f /var/lib/jenkins/workspace/ProjetSpring1/DevOps_Project/pom.xml sonar:sonar -Dsonar.login=sqa_22e0b819eff9a7c0299eb3ddcd2e55cf0506e6c4'

                      }
                  }
              }

        stage('JUNIT/MOCKITO') {
            steps {

                script {
                   sh 'mvn -f /var/lib/jenkins/workspace/ProjetSpring1/DevOps_Project/pom.xml clean test'
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