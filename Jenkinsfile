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

                sh 'mvn -f /home/vagrant/.jenkins/workspace/ProjetSpring1/DevOps_Project/pom.xml clean'
            }
        }
        stage('Maven Compile') {
            steps {
                sh 'mvn -f /home/vagrant/.jenkins/workspace/ProjetSpring1/DevOps_Project/pom.xml compile'
            }
        }
        stage('MVN SONARQUBE') {
            steps {
                script {
                    sh 'mvn -f /home/vagrant/.jenkins/workspace/ProjetSpring1/DevOps_Project/pom.xml sonar:sonar -Dsonar.login=sqa_fffd3cc16ccecdbc67d833015fd06e5ac3d34836'
                }
            }
        }

        stage('JUNIT/MOCKITO') {
            steps {
                script {
                    sh 'mvn -f /home/vagrant/.jenkins/workspace/ProjetSpring1/DevOps_Project/pom.xml clean test'
                }
            }
        }
 stage('Nexus') {
            steps {
                script {
                    sh 'mvn -f /home/vagrant/.jenkins/workspace/ProjetSpring1/DevOps_Project/pom.xml deploy'
                }
            }
        }
  stage('Docker Image') {
            steps {
                script {
                    // Change the working directory to where your Dockerfile is located
                    dir('/home/vagrant/.jenkins/workspace/ProjetSpring1/DevOps_Project') {
                        // Execute the docker build command from this directory
                        sh 'docker build -t khitemmathlouthi/devopsproject:1.0 -f Dockerfile .'
                    }
                }
            }
        }
  stage('Docker Hub') {
    steps {
        withCredentials([usernamePassword(credentialsId: '2dc5dd19-7bfd-429e-9078-864ae637ecc1', passwordVariable: 'khitem1234', usernameVariable: 'khitem.mathlouthi@esprit.tn')]) {
            sh "docker login -u khitem.mathlouthi@esprit.tn -p khitem1234"
            sh 'docker push khitemmathlouthi/devopsproject:1.0'
           
        }
    }
}
 stage('Docker-composee') {
            steps {
                script {
                    // Change the working directory to the directory containing docker-compose.yml
                    dir('/home/vagrant/.jenkins/workspace/ProjetSpring1/DevOps_Project') {
                        // Execute the docker-compose command
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
