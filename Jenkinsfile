pipeline {
    agent {
        docker { image 'maven:3.3.9' }
    }
    tools {
            maven 'Maven 3.3.9'
            jdk 'jdk8'
    }

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