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
          
                        sh 'docker build -t rahma09/devopsproject:1.0 -f Dockerfile .'
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