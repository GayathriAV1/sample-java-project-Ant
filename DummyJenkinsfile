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
        stage('SonarQube Analysis') {
            steps {
                script {
                    def scannerHome = tool 'MySonarScanner'
                    withSonarQubeEnv() {
                        bat "${scannerHome}/bin/sonar-scanner"
                    }
                }
            }
        }
        stage('Package') {
            steps {
                bat 'ant jar'
            }
        }
        stage('Artifact upload') {
            steps {
                   // Show the installed version of JFrog CLI.
                jf '-v'

                // Show the configured JFrog Platform instances.
                jf 'c show'

                // Ping Artifactory.
                jf 'rt ping'

                // Create a file and upload it to a repository named 'my-repo' in Artifactory
                bat 'echo > test-file'
                jf 'rt u test-file my-sample-ivy-dev/'

                // Publish the build-info to Artifactory.
                jf 'rt bp'

                // Download the test-file
                jf 'rt dl my-repo/test-file'
            }
        }
    }
}
