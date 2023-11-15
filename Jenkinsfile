pipeline {
  agent any
  stages {
    stage('GitHub Jenkins Ant Checkout') {
      steps {
        git 'https://github.com/GayathriAV1/sample-java-project-Ant.git'
      }
    }
  stage('SonarQube Analysis') {
    steps{
      script{
    def scannerHome = tool 'MySonarScanner';
    withSonarQubeEnv() {
      bat "${scannerHome}/bin/sonar-scanner"
    }
    }
    }
  }
  stage('Compile') {
    steps{
      bat 'ant compile'
    }
  }
  }
}
