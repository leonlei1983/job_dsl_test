pipeline {
    agent any
    options {
        buildDiscarder(logRotator(numToKeepStr: '30', artifactNumToKeepStr: '30'))
        disableConcurrentBuilds()
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