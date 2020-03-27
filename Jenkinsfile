pipeline {
    agent any
    options {
        buildDiscarder(logRotator(numToKeepStr: '30', artifactNumToKeepStr: '30'))
        disableConcurrentBuilds()
        parameters([
            Boolean(name: 'lei_migration', defaultValue: false)
        ])
    }
    stages {
        stage('Test jobDsl') {
            steps {
                jobDsl targets: 'test.groovy',
                   removedJobAction: 'DELETE',
                   removedViewAction: 'DELETE'
            }
        }
    }
}