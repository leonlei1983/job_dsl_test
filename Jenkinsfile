pipeline {
    agent any
    options {
        buildDiscarder(logRotator(numToKeepStr: '30', artifactNumToKeepStr: '30'))
        disableConcurrentBuilds()
    }
    stages {
        stage('Test jobDsl') {
            steps {
                script {
                    def lei_migration = "${env.lei_migration ?: 'false'}"
                }
                jobDsl targets: 'test.groovy',
                   removedJobAction: 'DELETE',
                   removedViewAction: 'DELETE'
            }
        }
    }
}