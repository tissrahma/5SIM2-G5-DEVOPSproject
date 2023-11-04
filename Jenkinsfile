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
                    sh 'mvn -f /var/lib/jenkins/workspace/ProjetSpring1/DevOps_Project/pom.xml sonar:sonar -Dsonar.login=sqa_942d4d1ba1a4b6e5dae203ca2afa2d1f050555f8'
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
 stage('Nexus') {
            steps {
                script {
                    sh 'mvn -f /var/lib/jenkins/workspace/ProjetSpring1/DevOps_Project/pom.xml deploy'
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
