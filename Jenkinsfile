pipeline {
    agent {
        docker { image 'maven:3.6.3' }
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
                sh 'cd ./flow'
                sh 'mvn clean install'
                sh 'cd ..'

            }
        }

        stage('build project') {
            steps {
                sh 'mvn clean install'

            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml'
                }
            }
        }
    }
}