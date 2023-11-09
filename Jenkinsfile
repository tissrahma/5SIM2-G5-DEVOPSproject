pipeline {
    agent any
	stages{
stage('Prepare Workspace') {
    steps {
        // Copy the JAR file into the workspace
        sh 'cp /var/lib/jenkins/workspace/ProjetSpring/DevOps_Project/target/DevOps_Project-2.1.jar .'
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
 
  stage('Docker Image') {
            steps {
                script {

                    dir('/var/lib/jenkins/workspace/ProjetSpring/DevOps_Project') {
          
                        sh 'docker build -t rahma09/devopsproject:1.0 -f Dockerfile . --no-cache'
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