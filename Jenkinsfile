pipeline {
    agent {
        docker { image 'maven:3.6.3-jdk-8' }
    }
    stages{
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }

        stage('build dependencies') {
            steps {
                dir("${env.WORKSPACE}/flow"){
                    sh 'pwd'
                    sh 'mvn -B -DskipTests clean install'
               }

            }
        }

        stage('build project') {
            steps {
                dir("${env.WORKSPACE}") {
                    sh 'mvn clean test'
                }

            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml'
                }
            }
        }
    }
}