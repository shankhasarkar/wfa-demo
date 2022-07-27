pipeline {
  agent any
    tools {
      maven 'maven3'
      jdk 'JDK8'
    }
    stages {
      stage('Build maven') {
        steps {
          sh 'pwd'
          sh 'mvn clean install package'
        }
      }
      stage('Copy Artifact') {
        steps {
          sh 'pwd'
          sh 'cp -r target/*.jar docker'
        }
      }
      stage('Build docker image') {
        steps {
          script {
            app = docker.build('rsdemoacr.azurecr.io/wfademo',"./docker")                
            withDockerRegistry([credentialsId: 'rsdemoacr-cred', url: 'https://rsdemoacr.azurecr.io']) {                
              app.push("${env.BUILD_NUMBER}")
              app.push('latest')
            }
          }
        }
      }
    }
}
