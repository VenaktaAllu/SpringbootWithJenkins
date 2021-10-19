pipeline {
    agent any
    triggers {
        pollSCM "* * * * *"
    }
    stages {
        stage('build') {
            steps {
                sh 'mvn spring-boot:run'
            }
        }
         stage('test') {
                    steps {
                        sh 'mvn test'
              }
          }
    }
}