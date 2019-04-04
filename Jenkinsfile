#!/usr/bin/env groovy

pipeline {

    agent any

    tools {
        maven "Maven"
        jdk "java11"
    }

    options {
        buildDiscarder(logRotator(numToKeepStr: "50"))
    }

    stages {

        stage("Build") {
            steps {
                sh "mvn -B package"
            }
        }
    }

    post {
        always {
            deleteDir()
        }
    }
}
