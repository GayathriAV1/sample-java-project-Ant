pipeline {
    agent any

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
        stage('Server') {
            steps {
                rtServer (
                    serverId: "Artifactory",
                    url: 'https://avg123.jfrog.io/artifactory',
                    username: 'jenkinsuser1',
                    password: 'Admin123',
                    bypassProxy: true,
                    timeout: 300
                )
            }
        }
        stage('Artifact upload') {
            steps {
                rtUpload (
                    serverId: "Artifactory",
                    spec: """{
                        "files": [
                            {
                                "pattern": "*.jar",
                                "target": "my-sample-ivy-dev"
                            }
                        ]
                    }"""
                )
            }
        }
    }
}
