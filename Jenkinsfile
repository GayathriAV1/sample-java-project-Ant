# Jenkins with GitHub Integration Pipeline Example
pipeline {
  agent any
  stages {
    stage('GitHub Jenkins Ant Build') {
      steps {
        git 'https://github.com/GayathriAV1/sample-java-project-Ant.git'
        sh 'ant clean compile test package war'
      }
    }
  }
}
