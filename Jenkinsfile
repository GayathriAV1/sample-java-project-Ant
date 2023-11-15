pipeline {
  agent any
  stages {
    stage('GitHub Jenkins Ant Build') {
      steps {
        git 'https://github.com/GayathriAV1/sample-java-project-Ant.git'
        bat 'ant compile'
      }
    }
  stage('SonarQube Analysis') {
    steps{
    def scannerHome = tool 'MySonarScanner';
    withSonarQubeEnv() {
      sh "${scannerHome}/bin/sonar-scanner"
    }
    }
  }
  }
}
