pipeline {
  agent any
  stages {
    stage('GitHub Jenkins Ant Build') {
      steps {
        git 'https://github.com/GayathriAV1/sample-java-project-Ant.git'
        bat 'ant clean compile test package war'
      }
    }
  }
}
