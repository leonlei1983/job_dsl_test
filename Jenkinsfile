pipeline {
    agent any
    options {
        buildDiscarder(logRotator(numToKeepStr: '30', artifactNumToKeepStr: '30'))
        disableConcurrentBuilds()
    }
    parameters {
        booleanParam(name: 'job_enable', defaultValue: "${env.job_enable ?: true}", description: '')
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
                    unstableOnDeprecation: true,
                    additionalParameters: [
                        job_enable: "${env.job_enable ?: 'true'}"
                    ]
            }
        }
    }
}