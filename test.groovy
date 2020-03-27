def migration = "${lei_migration}".toBoolean();

this.pipelineJob('example') {
    environmentVariables {

    }
    parameters {

    }
    properties {

    }
    triggers {

    }
    throttleConcurrentBuilds {

    }
    logRotator {
        numToKeep(30)
    }
    disabled()
}
