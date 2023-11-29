pipeline {
    agent any
    tools {
        jfrog 'jfrog-cli'
    }

    stages {
        stage('GitHub Jenkins Ant Checkout') {
            steps {
                git 'https://github.com/GayathriAV1/sample-java-project-Ant.git'
            }
        }
        stage('Compile') {
            steps {
                bat 'ant compile'
            }
        }
        stage('Package') {
            steps {
                bat 'ant jar'
            }
        }
        stage('Artifact upload') {
            steps {

                // Search for .jar file and upload it to the Artifactory repo
                jf 'rt u *.jar testantproject'

                // Publish the build-info to Artifactory.
                jf 'rt bp'

                //Jfrof Xray Scan
                jf 's *.jar'
               // jf 'rt bs'

            }
        }
    }
}
