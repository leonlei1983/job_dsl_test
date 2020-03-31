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
                    failOnMissingPlugin: true,
                    removedConfigFilesAction: 'DELETE',
                    removedJobAction: 'DISABLE',
                    removedViewAction: 'DELETE',
                    sandbox: true,
                    unstableOnDeprecation: true
            }
        }
    }
}