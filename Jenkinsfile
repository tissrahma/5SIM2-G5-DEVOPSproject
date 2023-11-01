pipeline {
    agent any
    stages {
        stage('Preparation') {
            steps {
                cleanWs()
            }
        }
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
stage('MVN SONARQUBE') {
    steps {
        script {
            // Change to the directory where your project's pom.xml file is located
            dir('/var/lib/jenkins/workspace/ProjetSpring1/DevOps_Project') {
                sh 'mvn verify sonar:sonar -Dsonar.organization=mathlouthikhitem -Dsonar.projectKey=tissrahma_5SIM2-G5-DEVOPSproject -Dsonar.host.url=https://sonarcloud.io -Dsonar.login=d95a96914938ef308a0dec636aca2a5c56fe6571'
            }
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
