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
                    checkout([$class: 'GitSCM', branches: [[name: 'RAHMA']], userRemoteConfigs: [[url: 'https://github.com/tissrahma/5SIM2-G5-DEVOPSproject']]])
                }
            }
        }
        stage('Maven Clean') {
            steps {
                sh 'mvn clean'
            }
        }
        stage('Maven Compile') {
            steps {
                sh 'mvn compile'
            }
        }
        stage('MVN SONARQUBE') {
            steps {
                script {
                    withSonarQubeEnv('SonarQubeServer') {
                        sh 'mvn verify sonar:sonar -Dsonar.organization=tissrahma -Dsonar.host.url=https://sonarcloud.io -Dsonar.login=$SONAR_TOKEN'
                    }
                }
            }
        }
        stage('JUNIT/MOCKITO') {
            steps {
                script {
                    sh 'mvn clean test'
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
