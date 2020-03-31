pipeline {
    agent any
    options {
        buildDiscarder(logRotator(numToKeepStr: '30', artifactNumToKeepStr: '30'))
        disableConcurrentBuilds()
    }
    stages {
        stage('Test jobDsl') {
            steps {
                jobDsl targets: 'seed.groovy',
                   removedJobAction: 'DELETE',
                   removedViewAction: 'DELETE'
            }
        }
    }
}