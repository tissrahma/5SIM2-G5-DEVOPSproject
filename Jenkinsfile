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
                sh 'mvn -f /var/lib/jenkins/workspace/ProjetSpring/DevOps_Project/pom.xml clean'
            }
        }
        stage('Maven Compile') {
            steps {
                sh 'mvn -f /var/lib/jenkins/workspace/ProjetSpring/DevOps_Project/pom.xml compile'
            }
        }
stage('MVN SONARQUBE') {
    steps {
        script {
            dir('/var/lib/jenkins/workspace/ProjetSpring/DevOps_Project') {
                sh 'mvn verify sonar:sonar -Dsonar.organization=tissrahma -Dsonar.projectKey=tissrahma_5SIM2-G5-DEVOPSproject -Dsonar.host.url=https://sonarcloud.io -Dsonar.login=6616dafb265809679c6da70758e5b1475871eade'
            }
        }
    }
}
    stage('JUNIT/MOCKITO') {
            steps {
                script {
                    sh 'mvn -f /var/lib/jenkins/workspace/ProjetSpring/DevOps_Project/pom.xml clean test'
                }
            }
        }
  
       stage('Docker Image') {
            steps {
                script {
                    dir('/var/lib/jenkins/workspace/ProjetSpring/DevOps_Project') {
                        sh 'docker build -t rahmaTiss5sim2/devopsproject:1.0 -f Dockerfile .'
                    }
                }
            }
        }
   stage('Docker Hub') {
    steps {
        withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', passwordVariable: 'Valentino10', usernameVariable: 'rahma09')]) {
            sh "docker login -u rahma09 -p Valentino10"
            sh 'docker push rahmaTiss5sim2/devopsproject:1.0'
        }
    }
}
stage('Docker-compose') {
    steps {
        script {
            dir('/var/lib/jenkins/workspace/ProjetSpring/DevOps_Project') {
                sh 'docker compose up -d'
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