pipeline {
    agent {
        docker {
            image 'maven:3.6.3-jdk-8'
            args '-v $HOME/.m2:/root/.m2'}
    }
    stages{
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