pipeline {
    agent any
    options {
        buildDiscarder(logRotator(numToKeepStr: '30', artifactNumToKeepStr: '30'))
        disableConcurrentBuilds()
    }
    properties {
        lei_migration = "${env.LEI_MIGRATION ?: 'false'}";
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