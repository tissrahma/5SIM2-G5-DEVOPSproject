pipeline {
    agent any
	stages{
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

  stage('Docker Image') {
            steps {
                script {

                    dir('/var/lib/jenkins/workspace/ProjetSpring/DevOps_Project') {
          
                        sh 'docker build -t rahma09/devopsproject:1.0 -f Dockerfile . --no-cache'
                    }
                }
            }
        }
   stage('Docker Hub') {
    steps {
        withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', passwordVariable: 'Valentino10', usernameVariable: 'rahma09')]) {
            sh "docker login -u rahma09 -p Valentino10"
            sh 'docker push rahma09/devopsproject:1.0'
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
}
	 
post {
    always {
        junit '**/target/surefire-reports/**/*.xml'
    }
}
}