#!/usr/bin/env groovy

pipeline {

    agent any

    tools {
        maven "Maven"
    }

    options {
        buildDiscarder(logRotator(numToKeepStr: "50"))
    }

    stages {

        stage("Build") {
            steps {
                ansiColor("xterm") {
                    sh "mvn package"
                }
            }
        }
    }

    post {
        always {
            deleteDir()
        }
    }
}
